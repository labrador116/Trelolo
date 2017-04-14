package com.example.sbt_markin_aa.trelolo.model.database.schema;

/**
 * Created by sbt-markin-aa on 13.04.17.
 */

public class TreloloDBSchema {
    public static final class LoginTable{
        public static final String NAME ="login_table";

        public static final class Columns {
            public static final String LOGIN = "login";
            public static final String  PASSWORD = "password";
        }
    }
}
