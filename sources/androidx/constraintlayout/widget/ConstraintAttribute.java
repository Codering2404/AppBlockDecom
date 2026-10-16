package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ConstraintAttribute {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f33078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f33079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AttributeType f33080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f33081d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f33082e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f33083f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f33084g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f33085h;

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.ConstraintAttribute$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f33086a;

        static {
            int[] iArr = new int[AttributeType.values().length];
            f33086a = iArr;
            try {
                iArr[AttributeType.REFERENCE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33086a[AttributeType.BOOLEAN_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33086a[AttributeType.STRING_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33086a[AttributeType.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33086a[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33086a[AttributeType.INT_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33086a[AttributeType.FLOAT_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f33086a[AttributeType.DIMENSION_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public ConstraintAttribute(String str, AttributeType attributeType, Object obj, boolean z2) {
        this.f33079b = str;
        this.f33080c = attributeType;
        this.f33078a = z2;
        k(obj);
    }

    public static HashMap b(HashMap map, View view) {
        HashMap map2 = new HashMap();
        Class<?> cls = view.getClass();
        for (String str : map.keySet()) {
            ConstraintAttribute constraintAttribute = (ConstraintAttribute) map.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    map2.put(str, new ConstraintAttribute(constraintAttribute, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    map2.put(str, new ConstraintAttribute(constraintAttribute, cls.getMethod("getMap" + str, null).invoke(view, null)));
                }
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            }
        }
        return map2;
    }

    public static void i(Context context, XmlPullParser xmlPullParser, HashMap map) {
        AttributeType attributeType;
        Object objValueOf;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.c5);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string = null;
        Object objValueOf2 = null;
        AttributeType attributeType2 = null;
        boolean z2 = false;
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i3);
            if (index == R.styleable.d5) {
                string = typedArrayObtainStyledAttributes.getString(index);
                if (string != null && string.length() > 0) {
                    string = Character.toUpperCase(string.charAt(0)) + string.substring(1);
                }
            } else if (index == R.styleable.n5) {
                string = typedArrayObtainStyledAttributes.getString(index);
                z2 = true;
            } else if (index == R.styleable.e5) {
                objValueOf2 = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                attributeType2 = AttributeType.BOOLEAN_TYPE;
            } else {
                if (index == R.styleable.g5) {
                    attributeType = AttributeType.COLOR_TYPE;
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.f5) {
                    attributeType = AttributeType.COLOR_DRAWABLE_TYPE;
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.k5) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    objValueOf = Float.valueOf(TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == R.styleable.h5) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.i5) {
                    attributeType = AttributeType.FLOAT_TYPE;
                    objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == R.styleable.j5) {
                    attributeType = AttributeType.INT_TYPE;
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(index, -1));
                } else if (index == R.styleable.m5) {
                    attributeType = AttributeType.STRING_TYPE;
                    objValueOf = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R.styleable.l5) {
                    attributeType = AttributeType.REFERENCE_TYPE;
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId == -1) {
                        resourceId = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    objValueOf = Integer.valueOf(resourceId);
                }
                Object obj = objValueOf;
                attributeType2 = attributeType;
                objValueOf2 = obj;
            }
        }
        if (string != null && objValueOf2 != null) {
            map.put(string, new ConstraintAttribute(string, attributeType2, objValueOf2, z2));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void j(View view, HashMap map) {
        Class<?> cls = view.getClass();
        for (String str : map.keySet()) {
            ConstraintAttribute constraintAttribute = (ConstraintAttribute) map.get(str);
            String str2 = constraintAttribute.f33078a ? str : "set" + str;
            try {
                int i3 = AnonymousClass1.f33086a[constraintAttribute.f33080c.ordinal()];
                Class cls2 = Float.TYPE;
                Class cls3 = Integer.TYPE;
                switch (i3) {
                    case 1:
                        cls.getMethod(str2, cls3).invoke(view, Integer.valueOf(constraintAttribute.f33081d));
                        break;
                    case 2:
                        cls.getMethod(str2, Boolean.TYPE).invoke(view, Boolean.valueOf(constraintAttribute.f33084g));
                        break;
                    case 3:
                        cls.getMethod(str2, CharSequence.class).invoke(view, constraintAttribute.f33083f);
                        break;
                    case 4:
                        cls.getMethod(str2, cls3).invoke(view, Integer.valueOf(constraintAttribute.f33085h));
                        break;
                    case 5:
                        Method method = cls.getMethod(str2, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(constraintAttribute.f33085h);
                        method.invoke(view, colorDrawable);
                        break;
                    case 6:
                        cls.getMethod(str2, cls3).invoke(view, Integer.valueOf(constraintAttribute.f33081d));
                        break;
                    case 7:
                        cls.getMethod(str2, cls2).invoke(view, Float.valueOf(constraintAttribute.f33082e));
                        break;
                    case 8:
                        cls.getMethod(str2, cls2).invoke(view, Float.valueOf(constraintAttribute.f33082e));
                        break;
                }
            } catch (IllegalAccessException e3) {
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                Log.e("TransitionLayout", e4.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                StringBuilder sb = new StringBuilder();
                sb.append(cls.getName());
                sb.append(" must have a method ");
                sb.append(str2);
                Log.e("TransitionLayout", sb.toString());
            } catch (InvocationTargetException e5) {
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                e5.printStackTrace();
            }
        }
    }

    public void a(View view) {
        String str;
        Class<?> cls = view.getClass();
        String str2 = this.f33079b;
        if (this.f33078a) {
            str = str2;
        } else {
            str = "set" + str2;
        }
        try {
            int i3 = AnonymousClass1.f33086a[this.f33080c.ordinal()];
            Class cls2 = Integer.TYPE;
            Class cls3 = Float.TYPE;
            switch (i3) {
                case 1:
                case 6:
                    cls.getMethod(str, cls2).invoke(view, Integer.valueOf(this.f33081d));
                    break;
                case 2:
                    cls.getMethod(str, Boolean.TYPE).invoke(view, Boolean.valueOf(this.f33084g));
                    break;
                case 3:
                    cls.getMethod(str, CharSequence.class).invoke(view, this.f33083f);
                    break;
                case 4:
                    cls.getMethod(str, cls2).invoke(view, Integer.valueOf(this.f33085h));
                    break;
                case 5:
                    Method method = cls.getMethod(str, Drawable.class);
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(this.f33085h);
                    method.invoke(view, colorDrawable);
                    break;
                case 7:
                    cls.getMethod(str, cls3).invoke(view, Float.valueOf(this.f33082e));
                    break;
                case 8:
                    cls.getMethod(str, cls3).invoke(view, Float.valueOf(this.f33082e));
                    break;
            }
        } catch (IllegalAccessException e3) {
            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            Log.e("TransitionLayout", e4.getMessage());
            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append(" must have a method ");
            sb.append(str);
            Log.e("TransitionLayout", sb.toString());
        } catch (InvocationTargetException e5) {
            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
            e5.printStackTrace();
        }
    }

    public String c() {
        return this.f33079b;
    }

    public AttributeType d() {
        return this.f33080c;
    }

    public float e() {
        switch (AnonymousClass1.f33086a[this.f33080c.ordinal()]) {
            case 2:
                return this.f33084g ? 1.0f : 0.0f;
            case 3:
                throw new RuntimeException("Cannot interpolate String");
            case 4:
            case 5:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 6:
                return this.f33081d;
            case 7:
                return this.f33082e;
            case 8:
                return this.f33082e;
            default:
                return Float.NaN;
        }
    }

    public void f(float[] fArr) {
        switch (AnonymousClass1.f33086a[this.f33080c.ordinal()]) {
            case 2:
                fArr[0] = this.f33084g ? 1.0f : 0.0f;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int i3 = (this.f33085h >> 24) & 255;
                float fPow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float fPow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float fPow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = fPow;
                fArr[1] = fPow2;
                fArr[2] = fPow3;
                fArr[3] = i3 / 255.0f;
                return;
            case 6:
                fArr[0] = this.f33081d;
                return;
            case 7:
                fArr[0] = this.f33082e;
                return;
            case 8:
                fArr[0] = this.f33082e;
                return;
            default:
                return;
        }
    }

    public boolean g() {
        int i3 = AnonymousClass1.f33086a[this.f33080c.ordinal()];
        return (i3 == 1 || i3 == 2 || i3 == 3) ? false : true;
    }

    public int h() {
        int i3 = AnonymousClass1.f33086a[this.f33080c.ordinal()];
        return (i3 == 4 || i3 == 5) ? 4 : 1;
    }

    public void k(Object obj) {
        switch (AnonymousClass1.f33086a[this.f33080c.ordinal()]) {
            case 1:
            case 6:
                this.f33081d = ((Integer) obj).intValue();
                break;
            case 2:
                this.f33084g = ((Boolean) obj).booleanValue();
                break;
            case 3:
                this.f33083f = (String) obj;
                break;
            case 4:
            case 5:
                this.f33085h = ((Integer) obj).intValue();
                break;
            case 7:
                this.f33082e = ((Float) obj).floatValue();
                break;
            case 8:
                this.f33082e = ((Float) obj).floatValue();
                break;
        }
    }

    public ConstraintAttribute(ConstraintAttribute constraintAttribute, Object obj) {
        this.f33078a = false;
        this.f33079b = constraintAttribute.f33079b;
        this.f33080c = constraintAttribute.f33080c;
        k(obj);
    }
}
