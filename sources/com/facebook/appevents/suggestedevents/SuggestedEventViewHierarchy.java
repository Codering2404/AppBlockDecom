package com.facebook.appevents.suggestedevents;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TimePicker;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
public final class SuggestedEventViewHierarchy {
    public static final SuggestedEventViewHierarchy INSTANCE = new SuggestedEventViewHierarchy();
    private static final List<Class<? extends View>> blacklistedViews = CollectionsKt.listOf((Object[]) new Class[]{Switch.class, Spinner.class, DatePicker.class, TimePicker.class, RadioGroup.class, RatingBar.class, EditText.class, AdapterView.class});

    private SuggestedEventViewHierarchy() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
    
        if (r5.isClickable() == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
    
        r1.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        r5 = com.facebook.appevents.codeless.internal.ViewHierarchy.getChildrenOfView(r5).iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
    
        if (r5.hasNext() == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        r1.addAll(getAllClickableViews(r5.next()));
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.List<android.view.View> getAllClickableViews(android.view.View r5) {
        /*
            java.lang.Class<com.facebook.appevents.suggestedevents.SuggestedEventViewHierarchy> r0 = com.facebook.appevents.suggestedevents.SuggestedEventViewHierarchy.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto La
            return r2
        La:
            java.lang.String r1 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)     // Catch: java.lang.Throwable -> L2d
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L2d
            r1.<init>()     // Catch: java.lang.Throwable -> L2d
            java.util.List<java.lang.Class<? extends android.view.View>> r3 = com.facebook.appevents.suggestedevents.SuggestedEventViewHierarchy.blacklistedViews     // Catch: java.lang.Throwable -> L2d
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L2d
        L1a:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L2d
            if (r4 == 0) goto L2f
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L2d
            java.lang.Class r4 = (java.lang.Class) r4     // Catch: java.lang.Throwable -> L2d
            boolean r4 = r4.isInstance(r5)     // Catch: java.lang.Throwable -> L2d
            if (r4 == 0) goto L1a
            goto L56
        L2d:
            r5 = move-exception
            goto L57
        L2f:
            boolean r3 = r5.isClickable()     // Catch: java.lang.Throwable -> L2d
            if (r3 == 0) goto L38
            r1.add(r5)     // Catch: java.lang.Throwable -> L2d
        L38:
            java.util.List r5 = com.facebook.appevents.codeless.internal.ViewHierarchy.getChildrenOfView(r5)     // Catch: java.lang.Throwable -> L2d
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L2d
        L40:
            boolean r3 = r5.hasNext()     // Catch: java.lang.Throwable -> L2d
            if (r3 == 0) goto L56
            java.lang.Object r3 = r5.next()     // Catch: java.lang.Throwable -> L2d
            android.view.View r3 = (android.view.View) r3     // Catch: java.lang.Throwable -> L2d
            java.util.List r3 = getAllClickableViews(r3)     // Catch: java.lang.Throwable -> L2d
            java.util.Collection r3 = (java.util.Collection) r3     // Catch: java.lang.Throwable -> L2d
            r1.addAll(r3)     // Catch: java.lang.Throwable -> L2d
            goto L40
        L56:
            return r1
        L57:
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r5, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.suggestedevents.SuggestedEventViewHierarchy.getAllClickableViews(android.view.View):java.util.List");
    }

    @JvmStatic
    public static final JSONObject getDictionaryOfView(View view, View clickedView) {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventViewHierarchy.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(clickedView, "clickedView");
            JSONObject jSONObject = new JSONObject();
            if (view == clickedView) {
                try {
                    jSONObject.put(ViewHierarchyConstants.IS_INTERACTED_KEY, true);
                } catch (JSONException unused) {
                }
            }
            updateBasicInfo(view, jSONObject);
            JSONArray jSONArray = new JSONArray();
            Iterator<View> it = ViewHierarchy.getChildrenOfView(view).iterator();
            while (it.hasNext()) {
                jSONArray.put(getDictionaryOfView(it.next(), clickedView));
            }
            jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, jSONArray);
            return jSONObject;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SuggestedEventViewHierarchy.class);
            return null;
        }
    }

    private final List<String> getTextOfChildren(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (View view2 : ViewHierarchy.getChildrenOfView(view)) {
                String textOfView = ViewHierarchy.getTextOfView(view2);
                if (textOfView.length() > 0) {
                    arrayList.add(textOfView);
                }
                arrayList.addAll(getTextOfChildren(view2));
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @JvmStatic
    public static final String getTextOfViewRecursively(View hostView) {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventViewHierarchy.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(hostView, "hostView");
            String textOfView = ViewHierarchy.getTextOfView(hostView);
            if (textOfView.length() > 0) {
                return textOfView;
            }
            String strJoin = TextUtils.join(" ", INSTANCE.getTextOfChildren(hostView));
            Intrinsics.checkNotNullExpressionValue(strJoin, "join(\" \", childrenText)");
            return strJoin;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SuggestedEventViewHierarchy.class);
            return null;
        }
    }

    @JvmStatic
    public static final void updateBasicInfo(View view, JSONObject json) {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventViewHierarchy.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                String textOfView = ViewHierarchy.getTextOfView(view);
                String hintOfView = ViewHierarchy.getHintOfView(view);
                json.put(ViewHierarchyConstants.CLASS_NAME_KEY, view.getClass().getSimpleName());
                json.put(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY, ViewHierarchy.getClassTypeBitmask(view));
                if (textOfView.length() > 0) {
                    json.put("text", textOfView);
                }
                if (hintOfView.length() > 0) {
                    json.put(ViewHierarchyConstants.HINT_KEY, hintOfView);
                }
                if (view instanceof EditText) {
                    json.put(ViewHierarchyConstants.INPUT_TYPE_KEY, ((EditText) view).getInputType());
                }
            } catch (JSONException unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SuggestedEventViewHierarchy.class);
        }
    }
}
