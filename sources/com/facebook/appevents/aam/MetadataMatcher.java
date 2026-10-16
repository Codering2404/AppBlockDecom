package com.facebook.appevents.aam;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
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
public final class MetadataMatcher {
    public static final MetadataMatcher INSTANCE = new MetadataMatcher();
    private static final int MAX_INDICATOR_LENGTH = 100;

    private MetadataMatcher() {
    }

    @JvmStatic
    public static final List<String> getAroundViewIndicators(View view) {
        if (CrashShieldHandler.isObjectCrashing(MetadataMatcher.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            ArrayList arrayList = new ArrayList();
            ViewGroup parentOfView = ViewHierarchy.getParentOfView(view);
            if (parentOfView != null) {
                for (View view2 : ViewHierarchy.getChildrenOfView(parentOfView)) {
                    if (view != view2) {
                        arrayList.addAll(INSTANCE.getTextIndicators(view2));
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataMatcher.class);
            return null;
        }
    }

    @JvmStatic
    public static final List<String> getCurrentViewIndicators(View view) {
        if (CrashShieldHandler.isObjectCrashing(MetadataMatcher.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            ArrayList arrayList = new ArrayList();
            arrayList.add(ViewHierarchy.getHintOfView(view));
            Object tag = view.getTag();
            if (tag != null) {
                arrayList.add(tag.toString());
            }
            CharSequence contentDescription = view.getContentDescription();
            if (contentDescription != null) {
                arrayList.add(contentDescription.toString());
            }
            int i3 = 0;
            try {
                if (view.getId() != -1) {
                    String resourceName = view.getResources().getResourceName(view.getId());
                    Intrinsics.checkNotNullExpressionValue(resourceName, "resourceName");
                    String[] strArr = (String[]) new Regex("/").m(resourceName, 0).toArray(new String[0]);
                    if (strArr.length == 2) {
                        arrayList.add(strArr[1]);
                    }
                }
            } catch (Resources.NotFoundException unused) {
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                String str = (String) obj;
                if (str.length() > 0 && str.length() <= 100) {
                    String lowerCase = str.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                    arrayList2.add(lowerCase);
                }
            }
            return arrayList2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataMatcher.class);
            return null;
        }
    }

    private final List<String> getTextIndicators(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (view instanceof EditText) {
                return arrayList;
            }
            if (view instanceof TextView) {
                String string = ((TextView) view).getText().toString();
                if (string.length() > 0 && string.length() < 100) {
                    String lowerCase = string.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                    arrayList.add(lowerCase);
                    return arrayList;
                }
            } else {
                Iterator<View> it = ViewHierarchy.getChildrenOfView(view).iterator();
                while (it.hasNext()) {
                    arrayList.addAll(getTextIndicators(it.next()));
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @JvmStatic
    public static final boolean matchIndicator(List<String> indicators, List<String> keys) {
        if (CrashShieldHandler.isObjectCrashing(MetadataMatcher.class)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(indicators, "indicators");
            Intrinsics.checkNotNullParameter(keys, "keys");
            Iterator<String> it = indicators.iterator();
            while (it.hasNext()) {
                if (INSTANCE.matchIndicator(it.next(), keys)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataMatcher.class);
            return false;
        }
    }

    @JvmStatic
    public static final boolean matchValue(String text, String rule) {
        if (CrashShieldHandler.isObjectCrashing(MetadataMatcher.class)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(rule, "rule");
            return new Regex(rule).k(text);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataMatcher.class);
            return false;
        }
    }

    private final boolean matchIndicator(String str, List<String> list) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (StringsKt.a0(str, it.next(), false, 2, null)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
