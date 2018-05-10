package example.com.ghx;

import io.reactivex.annotations.NonNull;

/**
 * @author gaohx
 * @date 2017/12/29
 */

public interface DataCallback<T> {
    /**
     * 数据返回成功
     * @param t
     */
    void onDataAvailable(T t);

    /**
     * 数据返回失败
     * @param e
     */
    void onDataNotAvailable(@NonNull Throwable e);
}
