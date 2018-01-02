package example.com.ghx;

/**
 * @author gaohx
 * @date 2018/1/2
 */

public interface BasePresenter<T> {
    /**
     * 添加视图绑定
     * @param view
     */
    void addView(T view);

    /**
     * 删除视图绑定
     */
    void removeView();
}
