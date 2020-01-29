package com.graduation.utils;

public class CodeMsg {

        private int code;
        private String msg;
        public int getCode() {
            return code;
        }
        public void setCode(int code) {
            this.code = code;
        }
        public String getMsg() {
            return msg;
        }
        public void setMsg(String msg) {
            this.msg = msg;
        }
        /**
         * 服务端异常
         */
        public static final CodeMsg SUCCESS = new CodeMsg(200,"SUCCESS");
        public static final CodeMsg SERVER_ERROR = new CodeMsg(500,"服务器异常");

        private CodeMsg( int code,String msg ) {
            this.code = code;
            this.msg = msg;
        }
        /**
         * 不定参的构造函数
         * @param args
         * @return
         */
        public CodeMsg fillArgs(Object... args) {
            int code = this.code;
            String message = String.format(this.msg, args);
            return new CodeMsg(code, message);
        }
        @Override
        public String toString() {
            return "CodeMsg [code=" + code + ", msg=" + msg + "]";
        }


}
