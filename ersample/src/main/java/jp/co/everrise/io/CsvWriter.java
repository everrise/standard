package jp.co.everrise.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;

import org.seasar.framework.beans.BeanDesc;
import org.seasar.framework.beans.PropertyDesc;
import org.seasar.framework.beans.factory.BeanDescFactory;

/**
 * オブジェクトをCSV形式でストリームに出力する{@link Writer}のラッパーです。
 *
 * @author shotaro.tsubouchi
 *
 */
public class CsvWriter implements Closeable {

	public static final int INITIAL_STRING_SIZE = 128;
	private char separator = ',';
	private char quotechar = '"';
	private char escapechar = '"';
	private String lineEnd = "\n";
	public boolean quote;

	private final Writer writer;

	public CsvWriter(Writer writer) {
		this.writer = writer;
	}

	/**
	 * オブジェクトを行として出力します。
	 *
	 * @param object
	 *            行データ
	 * @return
	 * @throws IOException
	 */
	public CsvWriter writeRow(Object object) throws IOException {
		StringBuilder line = new StringBuilder();
		BeanDesc beanDesc = BeanDescFactory.getBeanDesc(object.getClass());
		for (int i = 0, len = beanDesc.getPropertyDescSize(); i < len; i++) {
			if (i != 0) {
				line.append(separator);
			}
			PropertyDesc propertyDesc = beanDesc.getPropertyDesc(i);
			Object value = propertyDesc.getValue(object);
			if (value == null) {
				continue;
			}
			String str = value.toString();
			if (quote || str.indexOf(lineEnd) >= 0) {
				line.append(quotechar);
			}
			if (str.indexOf(quotechar) == -1 || str.indexOf(escapechar) == -1) {
				line.append(str);
			} else {
				escapeAppend(line, str);
			}
			if (quote || str.indexOf(lineEnd) >= 0) {
				line.append(quotechar);
			}
		}
		line.append(lineEnd);
		writer.write(line.toString());
		return this;
	}

	/**
	 * 文字列を行として出力します。
	 *
	 * @param values
	 *            行データ
	 * @return
	 * @throws IOException
	 */
	public CsvWriter writeRow(String value) throws IOException {
		return writeRow(new String[] { value });
	}

	/**
	 * 文字列配列を行として出力します。
	 *
	 * @param values
	 *            行データ
	 * @return
	 * @throws IOException
	 */
	public CsvWriter writeRow(String... values) throws IOException {
		StringBuilder line = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			if (i != 0) {
				line.append(separator);
			}
			Object value = values[i];
			if (value == null) {
				continue;
			}
			String str = value.toString();
			if (quote || str.indexOf(lineEnd) >= 0) {
				line.append(quotechar);
			}
			if (str.indexOf(quotechar) == -1 || str.indexOf(escapechar) == -1) {
				line.append(str);
			} else {
				escapeAppend(line, str);
			}
			if (quote || str.indexOf(lineEnd) >= 0) {
				line.append(quotechar);
			}
		}
		line.append(lineEnd);
		writer.write(line.toString());
		return this;
	}

	/**
	 * 改行します。
	 *
	 * @throws IOException
	 */
	public void println() throws IOException {
		writer.append(lineEnd);
	}

	/**
	 * Quoteを設定します。
	 *
	 * @return Quoteするかどうか
	 */
	public CsvWriter quote(boolean quote) {
		this.quote = quote;
		return this;
	}

	/**
	 * エスケープ処理を行います。
	 *
	 * @param builder
	 * @param value
	 * @return
	 */
	protected StringBuilder escapeAppend(StringBuilder builder, String value) {
		for (int j = 0; j < value.length(); j++) {
			char nextChar = value.charAt(j);
			if (nextChar == quotechar || nextChar == escapechar) {
				builder.append(escapechar);
			}
			builder.append(nextChar);
		}
		return builder;
	}

	@Override
	public void close() throws IOException {
		writer.close();
	}
}
