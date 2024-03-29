package com.graduation.utils;

public class ResultData<T> {
        /**
         * 业务自定义状态码
         */
        private int code;
        /**
         * 请求状态描述，调试用
         */
        private String msg;

        /**
         * 请求数据，对象或数组均可
         */
        private T data;

        /**
         * 成功时候的调用
         * @param data data
         * @param <T> t
         * @return Result
         */
        public static <T> ResultData<T> success(T data){
            return new ResultData<T>(data);
        }

        /**
         * 失败时候的调用
         * @param codeMsg codeMsg
         * @param <T> t
         * @return Result
         */
        public static <T> ResultData<T> error(CodeMsg codeMsg){
            return new ResultData<T>(codeMsg);
        }

        public ResultData(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        /**
         * 成功的构造函数
         * @param data data
         */
        public ResultData(T data){
            this.code = 200;
            this.msg = "SUCCESS";
            this.data = data;
        }

        /**
         * 失败的构造函数
         * @param codeMsg codeMsg
         */
        private ResultData(CodeMsg codeMsg) {
            if(codeMsg != null) {
                this.code = codeMsg.getCode();
                this.msg = codeMsg.getMsg();
            }
        }

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

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
}
