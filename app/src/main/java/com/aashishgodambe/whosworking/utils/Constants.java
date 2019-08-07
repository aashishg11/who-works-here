package com.aashishgodambe.whosworking.utils;

public class Constants {

    public static String BASE_URL = "https://s3.amazonaws.com/";

    public static final String MALFORMED_2_EMPLOYEES = "{\n" +
            "  \"employees\": [\n" +
            "    {\n" +
            "      \"uuid\": \"0d8fcc12-4d0c-425c-8355-390b312b909c\",\n" +
            "      \"full_name\": \"yyamille Rogers\",\n" +
            "      \"phone_number\": \"5553280123\",\n" +
            "      \"email_address\": \"jmason.demo@squareup.com\",\n" +
            "      \"biography\": \"Engineer on the Point of Sale team.\",\n" +
            "      \"photo_url_small\": \"https://s3.amazonaws.com/sq-mobile-interview/photos/16c00560-6dd3-4af4-97a6-d4754e7f2394/small.jpg\",\n" +
            "      \"photo_url_large\": \"https://s3.amazonaws.com/sq-mobile-interview/photos/16c00560-6dd3-4af4-97a6-d4754e7f2394/large.jpg\",\n" +
            "      \"employee_type\": \"FULL_TIME\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"uuid\": \"a98f8a2e-c975-4ba3-8b35-01f719e7de2d\",\n" +
            "      \"full_name\": \"Camille Rogers\",\n" +
            "      \"phone_number\": \"5558531970\",\n" +
            "      \"email_address\": \"crogers.demo@squareup.com\",\n" +
            "      \"biography\": \"Designer on the web marketing team.\",\n" +
            "      \"photo_url_small\": \"https://s3.amazonaws.com/sq-mobile-interview/photos/5095a907-abc9-4734-8d1e-0eeb2506bfa8/small.jpg\",\n" +
            "      \"photo_url_large\": \"https://s3.amazonaws.com/sq-mobile-interview/photos/5095a907-abc9-4734-8d1e-0eeb2506bfa8/large.jpg\",\n" +
            "      \"team\": \"Public Web & Marketing\",\n" +
            "      \"employee_type\": \"PART_TIME\"\n" +
            "    }]}";

    public static final String SUCCESS_200_3_EMPLOYEES = "{\n" +
            "  \"employees\": [\n" +
            "    {\n" +
            "      \"uuid\": \"0d8fcc12-4d0c-425c-8355-390b312b909c\",\n" +
            "      \"full_name\": \"Justine Mason\",\n" +
            "      \"phone_number\": \"5553280123\",\n" +
            "      \"email_address\": \"jmason.demo@squareup.com\",\n" +
            "      \"biography\": \"Engineer on the Point of Sale team.\",\n" +
            "      \"photo_url_small\": \"https://s3.amazonaws.com/sq-mobile-interview/photos/16c00560-6dd3-4af4-97a6-d4754e7f2394/small.jpg\",\n" +
            "      \"photo_url_large\": \"https://s3.amazonaws.com/sq-mobile-interview/photos/16c00560-6dd3-4af4-97a6-d4754e7f2394/large.jpg\",\n" +
            "      \"team\": \"Point of Sale\",\n" +
            "      \"employee_type\": \"FULL_TIME\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"uuid\": \"a98f8a2e-c975-4ba3-8b35-01f719e7de2d\",\n" +
            "      \"full_name\": \"Camille Rogers\",\n" +
            "      \"phone_number\": \"5558531970\",\n" +
            "      \"email_address\": \"crogers.demo@squareup.com\",\n" +
            "      \"biography\": \"Designer on the web marketing team.\",\n" +
            "      \"photo_url_small\": \"https://s3.amazonaws.com/sq-mobile-interview/photos/5095a907-abc9-4734-8d1e-0eeb2506bfa8/small.jpg\",\n" +
            "      \"photo_url_large\": \"https://s3.amazonaws.com/sq-mobile-interview/photos/5095a907-abc9-4734-8d1e-0eeb2506bfa8/large.jpg\",\n" +
            "      \"team\": \"Public Web & Marketing\",\n" +
            "      \"employee_type\": \"PART_TIME\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"uuid\": \"b8cf3382-ecf2-4240-b8ab-007688426e8c\",\n" +
            "      \"full_name\": \"Richard Stein\",\n" +
            "      \"phone_number\": \"5557223332\",\n" +
            "      \"email_address\": \"rstein.demo@squareup.com\",\n" +
            "      \"biography\": \"Product manager for the Point of sale app!\",\n" +
            "      \"photo_url_small\": \"https://s3.amazonaws.com/sq-mobile-interview/photos/43ed39b3-fbc0-4eb8-8ed3-6a8de479a52a/small.jpg\",\n" +
            "      \"photo_url_large\": \"https://s3.amazonaws.com/sq-mobile-interview/photos/43ed39b3-fbc0-4eb8-8ed3-6a8de479a52a/large.jpg\",\n" +
            "      \"team\": \"Point of Sale\",\n" +
            "      \"employee_type\": \"PART_TIME\"\n" +
            "    }]}";

    public static final String SUCCESS_200_2_EMPLOYEES_NO_IMAGE = "{\n" +
            "  \"employees\": [\n" +
            "    {\n" +
            "      \"uuid\": \"0d8fcc12-4d0c-425c-8355-390b312b909c\",\n" +
            "      \"full_name\": \"Justine Mason\",\n" +
            "      \"phone_number\": \"5553280123\",\n" +
            "      \"email_address\": \"jmason.demo@squareup.com\",\n" +
            "      \"biography\": \"Engineer on the Point of Sale team.\",\n" +
            "      \"photo_url_small\": \"https://s3.amazonaws.com/sq-mobile-interview/photos/16c00560-6dd3-4af4-97a6-d4754e7f2394/small.jpg\",\n" +
            "      \"photo_url_large\": \"https://s3.amazonaws.com/sq-mobile-interview/photos/16c00560-6dd3-4af4-97a6-d4754e7f2394/large.jpg\",\n" +
            "      \"team\": \"Point of Sale\",\n" +
            "      \"employee_type\": \"FULL_TIME\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"uuid\": \"a98f8a2e-c975-4ba3-8b35-01f719e7de2d\",\n" +
            "      \"full_name\": \"Camille Rogers\",\n" +
            "      \"phone_number\": \"5558531970\",\n" +
            "      \"email_address\": \"crogers.demo@squareup.com\",\n" +
            "      \"biography\": \"Designer on the web marketing team.\",\n" +
            "      \"photo_url_small\": \"\",\n" +
            "      \"photo_url_large\": \"https://s3.amazonaws.com/sq-mobile-interview/photos/5095a907-abc9-4734-8d1e-0eeb2506bfa8/large.jpg\",\n" +
            "      \"team\": \"Public Web & Marketing\",\n" +
            "      \"employee_type\": \"PART_TIME\"\n" +
            "    }]}";

    public static final String SUCCESS_200_EMPLOYEE_EMPTY = "{\n" +
            "  \"employees\": [\n" +
            "    \n" +
            "  ]\n" +
            "}";
}
