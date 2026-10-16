package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ConstraintLayoutStates {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f33164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ConstraintSet f33165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f33166c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f33167d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SparseArray f33168e = new SparseArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SparseArray f33169f = new SparseArray();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ConstraintsChangedListener f33170g = null;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class State {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f33171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList f33172b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f33173c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ConstraintSet f33174d;

        public State(Context context, XmlPullParser xmlPullParser) {
            this.f33173c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.A9);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.B9) {
                    this.f33171a = typedArrayObtainStyledAttributes.getResourceId(index, this.f33171a);
                } else if (index == R.styleable.C9) {
                    this.f33173c = typedArrayObtainStyledAttributes.getResourceId(index, this.f33173c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f33173c);
                    context.getResources().getResourceName(this.f33173c);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f33174d = constraintSet;
                        constraintSet.n(context, this.f33173c);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        void a(Variant variant) {
            this.f33172b.add(variant);
        }

        public int b(float f3, float f4) {
            for (int i3 = 0; i3 < this.f33172b.size(); i3++) {
                if (((Variant) this.f33172b.get(i3)).a(f3, f4)) {
                    return i3;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Variant {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f33175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f33176b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f33177c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f33178d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f33179e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ConstraintSet f33180f;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            this.f33175a = Float.NaN;
            this.f33176b = Float.NaN;
            this.f33177c = Float.NaN;
            this.f33178d = Float.NaN;
            this.f33179e = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.ka);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.la) {
                    this.f33179e = typedArrayObtainStyledAttributes.getResourceId(index, this.f33179e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f33179e);
                    context.getResources().getResourceName(this.f33179e);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f33180f = constraintSet;
                        constraintSet.n(context, this.f33179e);
                    }
                } else if (index == R.styleable.ma) {
                    this.f33178d = typedArrayObtainStyledAttributes.getDimension(index, this.f33178d);
                } else if (index == R.styleable.na) {
                    this.f33176b = typedArrayObtainStyledAttributes.getDimension(index, this.f33176b);
                } else if (index == R.styleable.oa) {
                    this.f33177c = typedArrayObtainStyledAttributes.getDimension(index, this.f33177c);
                } else if (index == R.styleable.pa) {
                    this.f33175a = typedArrayObtainStyledAttributes.getDimension(index, this.f33175a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        boolean a(float f3, float f4) {
            if (!Float.isNaN(this.f33175a) && f3 < this.f33175a) {
                return false;
            }
            if (!Float.isNaN(this.f33176b) && f4 < this.f33176b) {
                return false;
            }
            if (Float.isNaN(this.f33177c) || f3 <= this.f33177c) {
                return Float.isNaN(this.f33178d) || f4 <= this.f33178d;
            }
            return false;
        }
    }

    ConstraintLayoutStates(Context context, ConstraintLayout constraintLayout, int i3) {
        this.f33164a = constraintLayout;
        a(context, i3);
    }

    private void a(Context context, int i3) {
        String str;
        XmlResourceParser xml = context.getResources().getXml(i3);
        try {
            State state = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                b(context, xml);
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                state = new State(context, xml);
                                this.f33168e.put(state.f33171a, state);
                            }
                            break;
                        case 1382829617:
                            str = "StateSet";
                            name.equals(str);
                            break;
                        case 1657696882:
                            str = "layoutDescription";
                            name.equals(str);
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                Variant variant = new Variant(context, xml);
                                if (state != null) {
                                    state.a(variant);
                                }
                            }
                            break;
                    }
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
        }
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                constraintSet.G(context, xmlPullParser);
                this.f33169f.put(identifier, constraintSet);
                return;
            }
        }
    }

    public void c(ConstraintsChangedListener constraintsChangedListener) {
        this.f33170g = constraintsChangedListener;
    }

    public void d(int i3, float f3, float f4) {
        int iB;
        int i4 = this.f33166c;
        if (i4 == i3) {
            State state = i3 == -1 ? (State) this.f33168e.valueAt(0) : (State) this.f33168e.get(i4);
            int i5 = this.f33167d;
            if ((i5 == -1 || !((Variant) state.f33172b.get(i5)).a(f3, f4)) && this.f33167d != (iB = state.b(f3, f4))) {
                ConstraintSet constraintSet = iB == -1 ? this.f33165b : ((Variant) state.f33172b.get(iB)).f33180f;
                int i6 = iB == -1 ? state.f33173c : ((Variant) state.f33172b.get(iB)).f33179e;
                if (constraintSet == null) {
                    return;
                }
                this.f33167d = iB;
                ConstraintsChangedListener constraintsChangedListener = this.f33170g;
                if (constraintsChangedListener != null) {
                    constraintsChangedListener.b(-1, i6);
                }
                constraintSet.i(this.f33164a);
                ConstraintsChangedListener constraintsChangedListener2 = this.f33170g;
                if (constraintsChangedListener2 != null) {
                    constraintsChangedListener2.a(-1, i6);
                    return;
                }
                return;
            }
            return;
        }
        this.f33166c = i3;
        State state2 = (State) this.f33168e.get(i3);
        int iB2 = state2.b(f3, f4);
        ConstraintSet constraintSet2 = iB2 == -1 ? state2.f33174d : ((Variant) state2.f33172b.get(iB2)).f33180f;
        int i7 = iB2 == -1 ? state2.f33173c : ((Variant) state2.f33172b.get(iB2)).f33179e;
        if (constraintSet2 == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i3 + ", dim =" + f3 + ", " + f4);
            return;
        }
        this.f33167d = iB2;
        ConstraintsChangedListener constraintsChangedListener3 = this.f33170g;
        if (constraintsChangedListener3 != null) {
            constraintsChangedListener3.b(i3, i7);
        }
        constraintSet2.i(this.f33164a);
        ConstraintsChangedListener constraintsChangedListener4 = this.f33170g;
        if (constraintsChangedListener4 != null) {
            constraintsChangedListener4.a(i3, i7);
        }
    }
}
