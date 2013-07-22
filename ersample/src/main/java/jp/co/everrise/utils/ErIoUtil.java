package jp.co.everrise.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * IO関連のユーティリティクラス.
 * 
 * @author shotaro.tsubouchi
 */
public abstract class ErIoUtil {

	/**
	 * {@link Closeable}をクローズします。
	 * 
	 * @param closeable
	 *            クローズするCloseableオブジェクト
	 * @return true:クローズが成功した場合
	 */
	public static boolean close(Closeable closeable) {
		try {
			if (closeable != null) {
				closeable.close();
			}
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}
