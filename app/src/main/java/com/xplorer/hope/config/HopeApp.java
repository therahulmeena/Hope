package com.xplorer.hope.config;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseCrashReporting;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.xplorer.hope.object.WorkAd;

public class HopeApp extends Application {
    // app
    private static HopeApp instance;
    // Debugging tag for the application
    public static final String APPTAG = "HopeApp";
    public static final String[] TITLES = {
            "Dish Washing",
            "House Cleaning",
            "Cloth Washing",
            "Cooking",
            "Construction",
            "Wall paint",
            "Driver",
            "Guard",
            "Shop Worker",
            "Gardening",
            "Miscellaneous"
    };
    public static final String[] ImgUrl = {
            "http://blanchile.cl/wp-content/uploads/2014/07/ahorrar-agua.jpg",
            "http://uploads.staticjw.com/st/stadfirmastockholm2/stadning1.jpg",
            "http://rtvbudva.me/vijesti-slike/1411453524.jpg",
            "http://www.sn24.se/sites/sn24.se/files/styles/w600/public/352474-chef-cooking.jpg",
            "http://hsgroup.la/wp-content/themes/skt-full-width/images/banner_bg.jpg",
            "http://wallpaperscraft.com/image/80272/2560x1080.jpg",
            "http://wymancenter.org/wordpress/wp-content/uploads/2012/10/driver.jpg",
            "http://www.womenpghouse.com/example/slider3.jpg",
            "http://www.sbsgroup.com.pk/wp-content/uploads/2005/12/Services-and-Shop-12.jpg",
            "https://lh5.googleusercontent.com/-1cU8_40Gyj0/VB3ABp0JwGI/AAAAAAABEWo/G4eEtn0Xrrw/w620-h400/photo.jpg",
            "http://scottishgames.files.wordpress.com/2013/05/other-logo-national-theatre-of-scotland-1.jpg"

    };
    public static final String[] drawerTitlesWorker = {
            "Profile",
            "My Schedule",
            "Holidays",
            "History",
            "Employers",
            "Balance",
            "My Ads"
    };
    //SP variables

    public static String SELECTED_LANGUAGE = "selectedLanguage";
    public static String SELECTED_USER_TYPE = "selectedUserType";

    /**
     * Create main application
     */
    public HopeApp() {

    }

    /**
     * Create main application
     *
     * @param context
     */
    public HopeApp(final Context context) {
        this();
        attachBaseContext(context);
    }


    public static void setSPString(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(getInstance());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }


    public static void setSPBoolean(String key, boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(getInstance());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }


    public static void setSPInteger(String key, int value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(getInstance());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static Integer getSPInteger(String key) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(getInstance());
        return sharedPreferences.getInt(key, 0);
    }

    public static String getSPString(String key) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(getInstance());
        return sharedPreferences.getString(key, "");
    }

    public static Boolean getSPBoolean(String key) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(getInstance());
        return sharedPreferences.getBoolean(key, true);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        ParseObject.registerSubclass(WorkAd.class);
        // Initialize Crash Reporting.
        ParseCrashReporting.enable(this);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(this, "JY7mTiuGK4GHacsLmKg3ZlA2ctxcZF6j8Z7S7XVJ", "PX7zmXw36LJC7D7zOiWvYRs4ITG0SrcaVPSfrm5j");


        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        //ParseUser.getCurrentUser().saveInBackground();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }

    /**
     * Create main application
     *
     * @param instrumentation
     */
    public HopeApp(final Instrumentation instrumentation) {
        this();
        attachBaseContext(instrumentation.getTargetContext());
    }

    public static HopeApp getInstance() {

        if (instance == null) {
            instance = new HopeApp();
            return instance;

        } else {
            return instance;
        }
    }
}
