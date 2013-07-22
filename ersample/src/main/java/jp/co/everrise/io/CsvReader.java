package jp.co.everrise.io;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Field;

import org.seasar.framework.beans.BeanDesc;
import org.seasar.framework.beans.factory.BeanDescFactory;

/**
 * CSV形式の行データをオブジェクトで取得する{@link Reader}のラッパーです。
 * 
 * @author shotaro.tsubouchi
 * 
 */
public class CsvReader implements Closeable {

	private BufferedReader br;

	private boolean hasNext = true;

	private CsvParser parser;

	private int skipLines;

	private boolean linesSkiped;

	public CsvReader(Reader reader) {
		this(reader, CsvParser.DEFAULT_SEPARATOR, CsvParser.DEFAULT_QUOTE_CHARACTER, CsvParser.DEFAULT_ESCAPE_CHARACTER, 0,
				CsvParser.DEFAULT_STRICT_QUOTES);
	}

	public CsvReader(Reader reader, char separator, char quotechar, char escape, int line, boolean strictQuotes) {
		this.br = new BufferedReader(reader);
		this.parser = new CsvParser(separator, quotechar, escape, strictQuotes);
		this.skipLines = line;
	}

	/**
	 * 文字列の配列として次の行を取得します。
	 * 
	 * @return 行データの文字列配列
	 * @throws IOException
	 */
	public String[] readRow() throws IOException {
		String[] result = null;
		do {
			String nextLine = getNextLine();
			if (!hasNext) {
				return result;
			}
			String[] r = parser.parseLineMulti(nextLine);
			if (r.length > 0) {
				if (result == null) {
					result = r;
				} else {
					String[] t = new String[result.length + r.length];
					System.arraycopy(result, 0, t, 0, result.length);
					System.arraycopy(r, 0, t, result.length, r.length);
					result = t;
				}
			}
		} while (parser.isPending());
		return result;
	}

	/**
	 * 次の行をPOJOで取得します。
	 * 
	 * @param rowClass
	 *            取得する行データのクラス
	 * @return オブジェクト
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public <T> T readRow(Class<T> rowClass) throws IOException {
		String[] columns = readRow();
		if (columns == null) {
			return null;
		}
		BeanDesc beanDesc = BeanDescFactory.getBeanDesc(rowClass);
		T bean = (T) beanDesc.newInstance(null);
		Field[] fields = rowClass.getFields();
		int length = Math.min(fields.length, columns.length);
		for (int i = 0; i < length; i++) {
			beanDesc.getPropertyDesc(i).setValue(bean, columns[i]);
		}
		return bean;
	}

	/**
	 * 指定した行数分スキップします。
	 * 
	 * @param count
	 *            行数
	 * @throws IOException
	 */
	public void skipRows(int count) throws IOException {
		for (int i = 0; i < count; i++) {
			readRow();
		}
	}

	@Override
	public void close() throws IOException {
		br.close();
	}

	/**
	 * Reads the next line from the file.
	 * 
	 * @return the next line from the file without trailing newline
	 * @throws IOException
	 *             if bad things happen during the read
	 */
	private String getNextLine() throws IOException {
		if (!this.linesSkiped) {
			for (int i = 0; i < skipLines; i++) {
				br.readLine();
			}
			this.linesSkiped = true;
		}
		String nextLine = br.readLine();
		if (nextLine == null) {
			hasNext = false;
		}
		return hasNext ? nextLine : null;
	}
}
