package com.facebook.appevents.codeless.internal;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
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
public final class ViewHierarchy {
    private static final String CLASS_RCTROOTVIEW = "com.facebook.react.ReactRootView";
    private static final String CLASS_RCTVIEWGROUP = "com.facebook.react.views.view.ReactViewGroup";
    private static final String CLASS_TOUCHTARGETHELPER = "com.facebook.react.uimanager.TouchTargetHelper";
    private static final int ICON_MAX_EDGE_LENGTH = 44;
    private static final String METHOD_FIND_TOUCHTARGET_VIEW = "findTouchTargetView";
    private static Method methodFindTouchTargetView;
    public static final ViewHierarchy INSTANCE = new ViewHierarchy();
    private static final String TAG = ViewHierarchy.class.getCanonicalName();
    private static WeakReference<View> RCTRootViewReference = new WeakReference<>(null);

    private ViewHierarchy() {
    }

    @JvmStatic
    public static final View findRCTRootView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        while (view != null) {
            try {
                if (!INSTANCE.isRCTRootView(view)) {
                    Object parent = view.getParent();
                    if (!(parent instanceof View)) {
                        break;
                    }
                    view = (View) parent;
                } else {
                    return view;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            }
        }
        return null;
    }

    @JvmStatic
    public static final List<View> getChildrenOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (view instanceof ViewGroup) {
                int childCount = ((ViewGroup) view).getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    arrayList.add(((ViewGroup) view).getChildAt(i3));
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    @JvmStatic
    public static final int getClassTypeBitmask(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return 0;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            int i3 = view instanceof ImageView ? 2 : 0;
            if (view.isClickable()) {
                i3 |= 32;
            }
            if (isAdapterViewItem(view)) {
                i3 |= 512;
            }
            if (!(view instanceof TextView)) {
                if (!(view instanceof Spinner) && !(view instanceof DatePicker)) {
                    return view instanceof RatingBar ? 65536 | i3 : view instanceof RadioGroup ? i3 | 16384 : ((view instanceof ViewGroup) && INSTANCE.isRCTButton(view, RCTRootViewReference.get())) ? i3 | 64 : i3;
                }
                return i3 | 4096;
            }
            int i4 = i3 | 1025;
            if (view instanceof Button) {
                i4 = i3 | 1029;
                if (view instanceof Switch) {
                    i4 = i3 | 9221;
                } else if (view instanceof CheckBox) {
                    i4 = 33797 | i3;
                }
            }
            return view instanceof EditText ? i4 | 2048 : i4;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return 0;
        }
    }

    @JvmStatic
    public static final JSONObject getDictionaryOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            if (Intrinsics.areEqual(view.getClass().getName(), CLASS_RCTROOTVIEW)) {
                RCTRootViewReference = new WeakReference<>(view);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                updateBasicInfoOfView(view, jSONObject);
                JSONArray jSONArray = new JSONArray();
                List<View> childrenOfView = getChildrenOfView(view);
                int size = childrenOfView.size();
                for (int i3 = 0; i3 < size; i3++) {
                    jSONArray.put(getDictionaryOfView(childrenOfView.get(i3)));
                }
                jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, jSONArray);
                return jSONObject;
            } catch (JSONException e3) {
                Log.e(TAG, "Failed to create JSONObject for view.", e3);
                return jSONObject;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    private final JSONObject getDimensionOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, view.getTop());
                jSONObject.put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, view.getLeft());
                jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, view.getWidth());
                jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, view.getHeight());
                jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_X_KEY, view.getScrollX());
                jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_Y_KEY, view.getScrollY());
                jSONObject.put(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, view.getVisibility());
                return jSONObject;
            } catch (JSONException e3) {
                Log.e(TAG, "Failed to create JSONObject for dimension.", e3);
                return jSONObject;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Class<?> getExistingClass(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @JvmStatic
    public static final View.OnClickListener getExistingOnClickListener(View view) {
        Field declaredField;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.view.View.OnClickListener");
            return (View.OnClickListener) obj2;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    @JvmStatic
    public static final View.OnTouchListener getExistingOnTouchListener(View view) {
        Field declaredField;
        try {
            if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
                return null;
            }
            try {
                try {
                    Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
                    if (declaredField2 != null) {
                        declaredField2.setAccessible(true);
                    }
                    Object obj = declaredField2.get(view);
                    if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener")) == null) {
                        return null;
                    }
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(obj);
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.view.View.OnTouchListener");
                    return (View.OnTouchListener) obj2;
                } catch (NoSuchFieldException e3) {
                    Utility.logd(TAG, e3);
                }
            } catch (ClassNotFoundException e4) {
                Utility.logd(TAG, e4);
            } catch (IllegalAccessException e5) {
                Utility.logd(TAG, e5);
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    @JvmStatic
    public static final String getHintOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            CharSequence hint = view instanceof EditText ? ((EditText) view).getHint() : view instanceof TextView ? ((TextView) view).getHint() : null;
            if (hint == null) {
                return "";
            }
            String string = hint.toString();
            return string == null ? "" : string;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    @JvmStatic
    public static final ViewGroup getParentOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class) || view == null) {
            return null;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                return (ViewGroup) parent;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0102  */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String getTextOfView(android.view.View r7) {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.ViewHierarchy.getTextOfView(android.view.View):java.lang.String");
    }

    private final View getTouchReactView(float[] fArr, View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            initTouchTargetHelperMethods();
            Method method = methodFindTouchTargetView;
            if (method != null && view != null) {
                try {
                    if (method == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    Object objInvoke = method.invoke(null, fArr, view);
                    Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type android.view.View");
                    View view2 = (View) objInvoke;
                    if (view2.getId() > 0) {
                        Object parent = view2.getParent();
                        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
                        return (View) parent;
                    }
                } catch (IllegalAccessException e3) {
                    Utility.logd(TAG, e3);
                } catch (InvocationTargetException e4) {
                    Utility.logd(TAG, e4);
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final float[] getViewLocationOnScreen(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            view.getLocationOnScreen(new int[2]);
            return new float[]{r2[0], r2[1]};
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final void initTouchTargetHelperMethods() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (methodFindTouchTargetView != null) {
                return;
            }
            try {
                Method declaredMethod = Class.forName(CLASS_TOUCHTARGETHELPER).getDeclaredMethod(METHOD_FIND_TOUCHTARGET_VIEW, float[].class, ViewGroup.class);
                methodFindTouchTargetView = declaredMethod;
                if (declaredMethod == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                declaredMethod.setAccessible(true);
            } catch (ClassNotFoundException e3) {
                Utility.logd(TAG, e3);
            } catch (NoSuchMethodException e4) {
                Utility.logd(TAG, e4);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    private static final boolean isAdapterViewItem(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return false;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof AdapterView) {
                return true;
            }
            ViewHierarchy viewHierarchy = INSTANCE;
            Class<?> existingClass = viewHierarchy.getExistingClass("android.support.v4.view.NestedScrollingChild");
            if (existingClass != null && existingClass.isInstance(parent)) {
                return true;
            }
            Class<?> existingClass2 = viewHierarchy.getExistingClass("androidx.core.view.NestedScrollingChild");
            if (existingClass2 != null) {
                if (existingClass2.isInstance(parent)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return false;
        }
    }

    private final boolean isRCTRootView(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return Intrinsics.areEqual(view.getClass().getName(), CLASS_RCTROOTVIEW);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    @JvmStatic
    public static final void setOnClickListener(View view, View.OnClickListener onClickListener) {
        Field declaredField;
        Field declaredField2;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            Object obj = null;
            try {
                try {
                    declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
                    try {
                        declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
                    } catch (ClassNotFoundException | NoSuchFieldException unused) {
                        declaredField2 = null;
                    }
                } catch (Exception unused2) {
                    return;
                }
            } catch (ClassNotFoundException | NoSuchFieldException unused3) {
                declaredField = null;
            }
            if (declaredField == null || declaredField2 == null) {
                view.setOnClickListener(onClickListener);
                return;
            }
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            try {
                declaredField.setAccessible(true);
                obj = declaredField.get(view);
            } catch (IllegalAccessException unused4) {
            }
            if (obj == null) {
                view.setOnClickListener(onClickListener);
            } else {
                declaredField2.set(obj, onClickListener);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
        }
    }

    @JvmStatic
    public static final void updateAppearanceOfView(View view, JSONObject json, float f3) {
        Bitmap bitmap;
        Typeface typeface;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                JSONObject jSONObject = new JSONObject();
                if ((view instanceof TextView) && (typeface = ((TextView) view).getTypeface()) != null) {
                    jSONObject.put(ViewHierarchyConstants.TEXT_SIZE, ((TextView) view).getTextSize());
                    jSONObject.put(ViewHierarchyConstants.TEXT_IS_BOLD, typeface.isBold());
                    jSONObject.put(ViewHierarchyConstants.TEXT_IS_ITALIC, typeface.isItalic());
                    json.put(ViewHierarchyConstants.TEXT_STYLE, jSONObject);
                }
                if (view instanceof ImageView) {
                    Drawable drawable = ((ImageView) view).getDrawable();
                    if (!(drawable instanceof BitmapDrawable) || view.getHeight() / f3 > 44.0f || view.getWidth() / f3 > 44.0f || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null) {
                        return;
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    json.put(ViewHierarchyConstants.ICON_BITMAP, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                }
            } catch (JSONException e3) {
                Utility.logd(TAG, e3);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
        }
    }

    @JvmStatic
    public static final void updateBasicInfoOfView(View view, JSONObject json) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                String textOfView = getTextOfView(view);
                String hintOfView = getHintOfView(view);
                Object tag = view.getTag();
                CharSequence contentDescription = view.getContentDescription();
                json.put(ViewHierarchyConstants.CLASS_NAME_KEY, view.getClass().getCanonicalName());
                json.put(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY, getClassTypeBitmask(view));
                json.put("id", view.getId());
                if (SensitiveUserDataUtils.isSensitiveUserData(view)) {
                    json.put("text", "");
                    json.put(ViewHierarchyConstants.IS_USER_INPUT_KEY, true);
                } else {
                    json.put("text", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(textOfView), ""));
                }
                json.put(ViewHierarchyConstants.HINT_KEY, Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(hintOfView), ""));
                if (tag != null) {
                    json.put("tag", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(tag.toString()), ""));
                }
                if (contentDescription != null) {
                    json.put("description", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(contentDescription.toString()), ""));
                }
                json.put(ViewHierarchyConstants.DIMENSION_KEY, INSTANCE.getDimensionOfView(view));
            } catch (JSONException e3) {
                Utility.logd(TAG, e3);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
        }
    }

    public final boolean isRCTButton(View view, View view2) {
        View touchReactView;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            if (Intrinsics.areEqual(view.getClass().getName(), CLASS_RCTVIEWGROUP) && (touchReactView = getTouchReactView(getViewLocationOnScreen(view), view2)) != null) {
                if (touchReactView.getId() == view.getId()) {
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
