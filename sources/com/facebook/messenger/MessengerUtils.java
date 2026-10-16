package com.facebook.messenger;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.bolts.AppLinks;
import com.facebook.internal.FacebookSignatureValidator;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.messenger.MessengerThreadParams;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class MessengerUtils {
    public static final String EXTRA_APP_ID = "com.facebook.orca.extra.APPLICATION_ID";
    public static final String EXTRA_EXTERNAL_URI = "com.facebook.orca.extra.EXTERNAL_URI";
    public static final String EXTRA_IS_COMPOSE = "com.facebook.orca.extra.IS_COMPOSE";
    public static final String EXTRA_IS_REPLY = "com.facebook.orca.extra.IS_REPLY";
    public static final String EXTRA_METADATA = "com.facebook.orca.extra.METADATA";
    public static final String EXTRA_PARTICIPANTS = "com.facebook.orca.extra.PARTICIPANTS";
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.orca.extra.PROTOCOL_VERSION";
    public static final String EXTRA_REPLY_TOKEN_KEY = "com.facebook.orca.extra.REPLY_TOKEN";
    public static final String EXTRA_THREAD_TOKEN_KEY = "com.facebook.orca.extra.THREAD_TOKEN";
    public static final MessengerUtils INSTANCE = new MessengerUtils();
    public static final String ORCA_THREAD_CATEGORY_20150314 = "com.facebook.orca.category.PLATFORM_THREAD_20150314";
    public static final String PACKAGE_NAME = "com.facebook.orca";
    public static final int PROTOCOL_VERSION_20150314 = 20150314;
    private static final String TAG = "MessengerUtils";

    private MessengerUtils() {
    }

    private final Set<Integer> getAllAvailableProtocolVersions(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        HashSet hashSet = new HashSet();
        Cursor cursorQuery = contentResolver.query(Uri.parse("content://com.facebook.orca.provider.MessengerPlatformProvider/versions"), new String[]{"version"}, null, null, null);
        if (cursorQuery == null) {
            return hashSet;
        }
        try {
            int columnIndex = cursorQuery.getColumnIndex("version");
            while (cursorQuery.moveToNext()) {
                hashSet.add(Integer.valueOf(cursorQuery.getInt(columnIndex)));
            }
            Unit unit = Unit.f139807a;
            CloseableKt.a(cursorQuery, null);
            return hashSet;
        } finally {
        }
    }

    private final List<String> parseParticipants(String str) {
        if (str == null || str.length() == 0) {
            return CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) StringsKt.V0(str, new String[]{","}, false, 0, 6, null).toArray(new String[0]);
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str2 : strArr) {
            int length = str2.length() - 1;
            int i3 = 0;
            boolean z2 = false;
            while (i3 <= length) {
                boolean z3 = Intrinsics.compare((int) str2.charAt(!z2 ? i3 : length), 32) <= 0;
                if (z2) {
                    if (!z3) {
                        break;
                    }
                    length--;
                } else if (z3) {
                    i3++;
                } else {
                    z2 = true;
                }
            }
            arrayList.add(str2.subSequence(i3, length + 1).toString());
        }
        return arrayList;
    }

    private final void shareToMessenger20150314(Activity activity, int i3, ShareToMessengerParams shareToMessengerParams) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setFlags(1);
            intent.setPackage(PACKAGE_NAME);
            intent.putExtra("android.intent.extra.STREAM", shareToMessengerParams.getUri());
            intent.setType(shareToMessengerParams.getMimeType());
            intent.putExtra(EXTRA_PROTOCOL_VERSION, PROTOCOL_VERSION_20150314);
            intent.putExtra(EXTRA_APP_ID, FacebookSdk.getApplicationId());
            intent.putExtra(EXTRA_METADATA, shareToMessengerParams.getMetaData());
            intent.putExtra(EXTRA_EXTERNAL_URI, shareToMessengerParams.getExternalUri());
            activity.startActivityForResult(intent, i3);
        } catch (ActivityNotFoundException unused) {
            activity.startActivity(activity.getPackageManager().getLaunchIntentForPackage(PACKAGE_NAME));
        }
    }

    private final void startViewUri(Context context, String str) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public final void finishShareToMessenger(Activity activity, ShareToMessengerParams shareToMessengerParams) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareToMessengerParams, "shareToMessengerParams");
        Intent originalIntent = activity.getIntent();
        Set<String> categories = originalIntent.getCategories();
        if (categories == null) {
            activity.setResult(0, null);
            activity.finish();
            return;
        }
        if (!categories.contains(ORCA_THREAD_CATEGORY_20150314)) {
            activity.setResult(0, null);
            activity.finish();
            return;
        }
        Intrinsics.checkNotNullExpressionValue(originalIntent, "originalIntent");
        Bundle appLinkExtras = AppLinks.getAppLinkExtras(originalIntent);
        Intent intent = new Intent();
        if (appLinkExtras == null || !categories.contains(ORCA_THREAD_CATEGORY_20150314)) {
            throw new RuntimeException();
        }
        intent.putExtra(EXTRA_PROTOCOL_VERSION, PROTOCOL_VERSION_20150314);
        intent.putExtra(EXTRA_THREAD_TOKEN_KEY, appLinkExtras.getString(EXTRA_THREAD_TOKEN_KEY));
        intent.setDataAndType(shareToMessengerParams.getUri(), shareToMessengerParams.getMimeType());
        intent.setFlags(1);
        intent.putExtra(EXTRA_APP_ID, FacebookSdk.getApplicationId());
        intent.putExtra(EXTRA_METADATA, shareToMessengerParams.getMetaData());
        intent.putExtra(EXTRA_EXTERNAL_URI, shareToMessengerParams.getExternalUri());
        activity.setResult(-1, intent);
        activity.finish();
    }

    public final MessengerThreadParams getMessengerThreadParamsForIntent(Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Set<String> categories = intent.getCategories();
            if (categories != null && categories.contains(ORCA_THREAD_CATEGORY_20150314)) {
                Bundle appLinkExtras = AppLinks.getAppLinkExtras(intent);
                String string = appLinkExtras != null ? appLinkExtras.getString(EXTRA_THREAD_TOKEN_KEY) : null;
                String string2 = appLinkExtras != null ? appLinkExtras.getString(EXTRA_METADATA) : null;
                String string3 = appLinkExtras != null ? appLinkExtras.getString(EXTRA_PARTICIPANTS) : null;
                Boolean boolValueOf = appLinkExtras != null ? Boolean.valueOf(appLinkExtras.getBoolean(EXTRA_IS_REPLY)) : null;
                Boolean boolValueOf2 = appLinkExtras != null ? Boolean.valueOf(appLinkExtras.getBoolean(EXTRA_IS_COMPOSE)) : null;
                Boolean bool = Boolean.TRUE;
                MessengerThreadParams.Origin origin = Intrinsics.areEqual(boolValueOf, bool) ? MessengerThreadParams.Origin.REPLY_FLOW : Intrinsics.areEqual(boolValueOf2, bool) ? MessengerThreadParams.Origin.COMPOSE_FLOW : MessengerThreadParams.Origin.UNKNOWN;
                if (string != null && string2 != null) {
                    return new MessengerThreadParams(origin, string, string2, parseParticipants(string3));
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final boolean hasMessengerInstalled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return FacebookSignatureValidator.validateSignature(context, PACKAGE_NAME);
    }

    public final void openMessengerInPlayStore(Context context) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                startViewUri(context, "market://details?id=com.facebook.orca");
            } catch (ActivityNotFoundException unused) {
                startViewUri(context, "http://play.google.com/store/apps/details?id=com.facebook.orca");
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void shareToMessenger(Activity activity, int i3, ShareToMessengerParams shareToMessengerParams) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(shareToMessengerParams, "shareToMessengerParams");
            if (!hasMessengerInstalled(activity)) {
                openMessengerInPlayStore(activity);
            } else if (getAllAvailableProtocolVersions(activity).contains(Integer.valueOf(PROTOCOL_VERSION_20150314))) {
                shareToMessenger20150314(activity, i3, shareToMessengerParams);
            } else {
                openMessengerInPlayStore(activity);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
