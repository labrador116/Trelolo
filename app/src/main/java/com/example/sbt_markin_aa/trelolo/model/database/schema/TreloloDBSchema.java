package com.example.sbt_markin_aa.trelolo.model.database.schema;

/**
 * Created by sbt-markin-aa on 13.04.17.
 */

public class TreloloDBSchema {

    public static final class LoginTable{
        public static final String NAME ="login_table";

        public static final class Columns {
            public static final String PERSON_ID="person_id";
            public static final String LOGIN = "login";
            public static final String  PASSWORD = "password";
        }
    }

    public static final  class PersonTable {
        public static final String NAME = "person_table";


        public static final class Columns {
            public static final String PERSON_ID = "person_id";
            public static final String Name = "name";
            public static final String SURNAME = "surname";
        }
    }

    public static final class StickerTable{
        public static final String NAME = "sticker_table";

        public static final class Columns {
            public static final String AUTHOR_ID = "author_id";
            public static final String TITLE = "title";
            public static final String TEXT = "text";
        }
    }
}
