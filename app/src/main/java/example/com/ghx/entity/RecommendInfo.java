package example.com.ghx.entity;

import java.util.List;

/**
 * 首页推荐信息
 * @author gaohx
 * @date 2017/12/19
 */
public class RecommendInfo {
    /**
     * code : 0
     * result : [{"type":"recommend","head":{"param":"","goto":"","style":"gm_av","title":"热门焦点"},"body":[{"title":"【灯泡】弹丸论破-绝望异世界-第一章（非日常篇上）","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/6785972c28e662bafd8f90be97111eb889f584c7.jpg","param":"15737645","goto":"av","width":350,"height":219,"play":"14.1万","danmaku":"3446","up":"大大大灯泡"}]}]
     */

    private int code;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * type : recommend
         * head : {"param":"","goto":"","style":"gm_av","title":"热门焦点"}
         * body : [{"title":"【灯泡】弹丸论破-绝望异世界-第一章（非日常篇上）","style":"gm_av","cover":"http://i0.hdslb.com/bfs/archive/6785972c28e662bafd8f90be97111eb889f584c7.jpg","param":"15737645","goto":"av","width":350,"height":219,"play":"14.1万","danmaku":"3446","up":"大大大灯泡"}]
         */

        private String type;
        private HeadBean head;
        private List<BodyBean> body;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public HeadBean getHead() {
            return head;
        }

        public void setHead(HeadBean head) {
            this.head = head;
        }

        public List<BodyBean> getBody() {
            return body;
        }

        public void setBody(List<BodyBean> body) {
            this.body = body;
        }

        public static class HeadBean {
            /**
             * param :
             * goto :
             * style : gm_av
             * title : 热门焦点
             */

            private String param;
            @com.google.gson.annotations.SerializedName("goto")
            private String gotoX;
            private String style;
            private String title;

            public String getParam() {
                return param;
            }

            public void setParam(String param) {
                this.param = param;
            }

            public String getGotoX() {
                return gotoX;
            }

            public void setGotoX(String gotoX) {
                this.gotoX = gotoX;
            }

            public String getStyle() {
                return style;
            }

            public void setStyle(String style) {
                this.style = style;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class BodyBean {
            /**
             * title : 【灯泡】弹丸论破-绝望异世界-第一章（非日常篇上）
             * style : gm_av
             * cover : http://i0.hdslb.com/bfs/archive/6785972c28e662bafd8f90be97111eb889f584c7.jpg
             * param : 15737645
             * goto : av
             * width : 350
             * height : 219
             * play : 14.1万
             * danmaku : 3446
             * up : 大大大灯泡
             */

            private String title;
            private String style;
            private String cover;
            private String param;
            @com.google.gson.annotations.SerializedName("goto")
            private String gotoX;
            private int width;
            private int height;
            private String play;
            private String danmaku;
            private String up;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getStyle() {
                return style;
            }

            public void setStyle(String style) {
                this.style = style;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getParam() {
                return param;
            }

            public void setParam(String param) {
                this.param = param;
            }

            public String getGotoX() {
                return gotoX;
            }

            public void setGotoX(String gotoX) {
                this.gotoX = gotoX;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getPlay() {
                return play;
            }

            public void setPlay(String play) {
                this.play = play;
            }

            public String getDanmaku() {
                return danmaku;
            }

            public void setDanmaku(String danmaku) {
                this.danmaku = danmaku;
            }

            public String getUp() {
                return up;
            }

            public void setUp(String up) {
                this.up = up;
            }
        }
    }
}
