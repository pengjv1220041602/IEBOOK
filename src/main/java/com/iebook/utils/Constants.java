package com.iebook.utils;

/**
 * 常量类
 */
public class Constants {

    /**
     * @deprecation: 权限代码值
     *
     * @param:
     * @return:
     */
    public static class PowerCode {
        public static final int ADMIN_CODE = 1;
        public static final int USER_CODE = 0;
    }

    /**
     * @deprecation: 审核code值
     *
     * @param:
     * @return:
     */
    public static class ExamineCode {
        public static final int NO_AND_PASS = -1;
        public static final int WAIT_EXAMINE = 0;
        public static final int PASS = 1;
        public static final int NO_PASS = 2;
    }


    /**
     * 代码值
     */
    public static class Code {
        /**
         * 成功代码值
         */
        public static final int SUCCESS_CODE= 200;

        /**
         * 失败代码值
         */
        public static final int ERROR_CODE = 1000;

        /**
         * 异常代码值
         */
        public static final int EXCEPTION_CODE = 500;

        /**
         * 已经存在
         */
        public static final int EXIST_CODE = 1;

        /**
         * 不存在
         */
        public static final int NO_EXIST_CODE = 0;
    }
}
