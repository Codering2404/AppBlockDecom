package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class StateSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f33400a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f33401b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f33402c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SparseArray f33403d = new SparseArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SparseArray f33404e = new SparseArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ConstraintsChangedListener f33405f = null;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class State {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f33406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList f33407b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f33408c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f33409d;

        public State(Context context, XmlPullParser xmlPullParser) {
            this.f33408c = -1;
            this.f33409d = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.A9);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.B9) {
                    this.f33406a = typedArrayObtainStyledAttributes.getResourceId(index, this.f33406a);
                } else if (index == R.styleable.C9) {
                    this.f33408c = typedArrayObtainStyledAttributes.getResourceId(index, this.f33408c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f33408c);
                    context.getResources().getResourceName(this.f33408c);
                    if ("layout".equals(resourceTypeName)) {
                        this.f33409d = true;
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        void a(Variant variant) {
            this.f33407b.add(variant);
        }

        public int b(float f3, float f4) {
            for (int i3 = 0; i3 < this.f33407b.size(); i3++) {
                if (((Variant) this.f33407b.get(i3)).a(f3, f4)) {
                    return i3;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Variant {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f33410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f33411b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f33412c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f33413d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f33414e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f33415f;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            this.f33410a = Float.NaN;
            this.f33411b = Float.NaN;
            this.f33412c = Float.NaN;
            this.f33413d = Float.NaN;
            this.f33414e = -1;
            this.f33415f = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.ka);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.la) {
                    this.f33414e = typedArrayObtainStyledAttributes.getResourceId(index, this.f33414e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f33414e);
                    context.getResources().getResourceName(this.f33414e);
                    if ("layout".equals(resourceTypeName)) {
                        this.f33415f = true;
                    }
                } else if (index == R.styleable.ma) {
                    this.f33413d = typedArrayObtainStyledAttributes.getDimension(index, this.f33413d);
                } else if (index == R.styleable.na) {
                    this.f33411b = typedArrayObtainStyledAttributes.getDimension(index, this.f33411b);
                } else if (index == R.styleable.oa) {
                    this.f33412c = typedArrayObtainStyledAttributes.getDimension(index, this.f33412c);
                } else if (index == R.styleable.pa) {
                    this.f33410a = typedArrayObtainStyledAttributes.getDimension(index, this.f33410a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        boolean a(float f3, float f4) {
            if (!Float.isNaN(this.f33410a) && f3 < this.f33410a) {
                return false;
            }
            if (!Float.isNaN(this.f33411b) && f4 < this.f33411b) {
                return false;
            }
            if (Float.isNaN(this.f33412c) || f3 <= this.f33412c) {
                return Float.isNaN(this.f33413d) || f4 <= this.f33413d;
            }
            return false;
        }
    }

    public StateSet(Context context, XmlPullParser xmlPullParser) {
        b(context, xmlPullParser);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void b(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.F9);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i3);
            if (index == R.styleable.G9) {
                this.f33400a = typedArrayObtainStyledAttributes.getResourceId(index, this.f33400a);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        try {
            int eventType = xmlPullParser.getEventType();
            State state = null;
            while (eventType != 1) {
                if (eventType == 0) {
                    xmlPullParser.getName();
                } else if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    switch (name.hashCode()) {
                        case 80204913:
                            if (name.equals("State")) {
                                state = new State(context, xmlPullParser);
                                this.f33403d.put(state.f33406a, state);
                            }
                            break;
                        case 1301459538:
                            name.equals("LayoutDescription");
                            break;
                        case 1382829617:
                            name.equals("StateSet");
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                Variant variant = new Variant(context, xmlPullParser);
                                if (state != null) {
                                    state.a(variant);
                                }
                            }
                            break;
                    }
                } else if (eventType != 3) {
                    continue;
                } else if ("StateSet".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
        }
    }

    public int a(int i3, int i4, float f3, float f4) {
        State state = (State) this.f33403d.get(i4);
        if (state == null) {
            return i4;
        }
        int i5 = 0;
        if (f3 != -1.0f && f4 != -1.0f) {
            ArrayList arrayList = state.f33407b;
            int size = arrayList.size();
            Variant variant = null;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                Variant variant2 = (Variant) obj;
                if (variant2.a(f3, f4)) {
                    if (i3 != variant2.f33414e) {
                        variant = variant2;
                    }
                }
            }
            return variant != null ? variant.f33414e : state.f33408c;
        }
        if (state.f33408c != i3) {
            ArrayList arrayList2 = state.f33407b;
            int size2 = arrayList2.size();
            while (i5 < size2) {
                Object obj2 = arrayList2.get(i5);
                i5++;
                if (i3 == ((Variant) obj2).f33414e) {
                }
            }
            return state.f33408c;
        }
        return i3;
    }

    public int c(int i3, int i4, int i5) {
        return d(-1, i3, i4, i5);
    }

    public int d(int i3, int i4, float f3, float f4) {
        int iB;
        if (i3 == i4) {
            State state = i4 == -1 ? (State) this.f33403d.valueAt(0) : (State) this.f33403d.get(this.f33401b);
            if (state == null) {
                return -1;
            }
            return ((this.f33402c == -1 || !((Variant) state.f33407b.get(i3)).a(f3, f4)) && i3 != (iB = state.b(f3, f4))) ? iB == -1 ? state.f33408c : ((Variant) state.f33407b.get(iB)).f33414e : i3;
        }
        State state2 = (State) this.f33403d.get(i4);
        if (state2 == null) {
            return -1;
        }
        int iB2 = state2.b(f3, f4);
        return iB2 == -1 ? state2.f33408c : ((Variant) state2.f33407b.get(iB2)).f33414e;
    }
}
