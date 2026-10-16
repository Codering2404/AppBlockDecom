package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.sun.jna.Function;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MotionScene {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MotionLayout f32863a;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private MotionEvent f32876n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MotionLayout.MotionTracker f32879q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f32880r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final ViewTransitionController f32881s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    float f32882t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    float f32883u;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    StateSet f32864b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Transition f32865c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f32866d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList f32867e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Transition f32868f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList f32869g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SparseArray f32870h = new SparseArray();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private HashMap f32871i = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private SparseIntArray f32872j = new SparseIntArray();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f32873k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f32874l = RCHTTPStatusCodes.BAD_REQUEST;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f32875m = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f32877o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f32878p = false;

    MotionScene(Context context, MotionLayout motionLayout, int i3) {
        this.f32863a = motionLayout;
        this.f32881s = new ViewTransitionController(motionLayout);
        K(context, i3);
        SparseArray sparseArray = this.f32870h;
        int i4 = R.id.f33298a;
        sparseArray.put(i4, new ConstraintSet());
        this.f32871i.put("motion_base", Integer.valueOf(i4));
    }

    private boolean I(int i3) {
        int i4 = this.f32872j.get(i3);
        int size = this.f32872j.size();
        while (i4 > 0) {
            if (i4 == i3) {
                return true;
            }
            int i5 = size - 1;
            if (size < 0) {
                return true;
            }
            i4 = this.f32872j.get(i4);
            size = i5;
        }
        return false;
    }

    private boolean J() {
        return this.f32879q != null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void K(Context context, int i3) {
        XmlResourceParser xml = context.getResources().getXml(i3);
        try {
            Transition transition = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    if (this.f32873k) {
                        System.out.println("parsing = " + name);
                    }
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                L(context, xml);
                            }
                            break;
                        case -1239391468:
                            if (name.equals("KeyFrameSet")) {
                                KeyFrames keyFrames = new KeyFrames(context, xml);
                                if (transition != null) {
                                    transition.f32895k.add(keyFrames);
                                }
                            }
                            break;
                        case -687739768:
                            if (name.equals("Include")) {
                                N(context, xml);
                            }
                            break;
                        case 61998586:
                            if (name.equals("ViewTransition")) {
                                this.f32881s.a(new ViewTransition(context, xml));
                            }
                            break;
                        case 269306229:
                            if (name.equals("Transition")) {
                                ArrayList arrayList = this.f32867e;
                                transition = new Transition(this, context, xml);
                                arrayList.add(transition);
                                if (this.f32865c == null && !transition.f32886b) {
                                    this.f32865c = transition;
                                    if (transition.f32896l != null) {
                                        this.f32865c.f32896l.x(this.f32880r);
                                    }
                                }
                                if (transition.f32886b) {
                                    if (transition.f32887c == -1) {
                                        this.f32868f = transition;
                                    } else {
                                        this.f32869g.add(transition);
                                    }
                                    this.f32867e.remove(transition);
                                }
                            }
                            break;
                        case 312750793:
                            if (name.equals("OnClick") && transition != null) {
                                transition.u(context, xml);
                            }
                            break;
                        case 327855227:
                            if (name.equals("OnSwipe")) {
                                if (transition == null) {
                                    Log.v("MotionScene", " OnSwipe (" + context.getResources().getResourceEntryName(i3) + ".xml:" + xml.getLineNumber() + ")");
                                }
                                if (transition != null) {
                                    transition.f32896l = new TouchResponse(context, this.f32863a, xml);
                                }
                            }
                            break;
                        case 793277014:
                            if (name.equals("MotionScene")) {
                                O(context, xml);
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                this.f32864b = new StateSet(context, xml);
                            }
                            break;
                        case 1942574248:
                            if (name.equals("include")) {
                                N(context, xml);
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

    private int L(Context context, XmlPullParser xmlPullParser) {
        String attributeValue;
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.T(false);
        int attributeCount = xmlPullParser.getAttributeCount();
        int iR = -1;
        int iR2 = -1;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            attributeValue = xmlPullParser.getAttributeValue(i3);
            if (this.f32873k) {
                System.out.println("id string = " + attributeValue);
            }
            attributeName.getClass();
            switch (attributeName) {
                case "deriveConstraintsFrom":
                    iR2 = r(context, attributeValue);
                    break;
                case "constraintRotate":
                    try {
                        constraintSet.f33187d = Integer.parseInt(attributeValue);
                        break;
                    } catch (NumberFormatException unused) {
                        attributeValue.getClass();
                        switch (attributeValue) {
                            case "x_left":
                                constraintSet.f33187d = 4;
                                break;
                            case "left":
                                constraintSet.f33187d = 2;
                                break;
                            case "none":
                                constraintSet.f33187d = 0;
                                break;
                            case "right":
                                constraintSet.f33187d = 1;
                                break;
                            case "x_right":
                                constraintSet.f33187d = 3;
                                break;
                        }
                    }
                    break;
                case "id":
                    iR = r(context, attributeValue);
                    this.f32871i.put(a0(attributeValue), Integer.valueOf(iR));
                    constraintSet.f33185b = Debug.c(context, iR);
                    break;
            }
        }
        if (iR != -1) {
            if (this.f32863a.f32784x != 0) {
                constraintSet.U(true);
            }
            constraintSet.G(context, xmlPullParser);
            if (iR2 != -1) {
                this.f32872j.put(iR, iR2);
            }
            this.f32870h.put(iR, constraintSet);
        }
        return iR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int M(Context context, int i3) {
        XmlResourceParser xml = context.getResources().getXml(i3);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && "ConstraintSet".equals(name)) {
                    return L(context, xml);
                }
            }
            return -1;
        } catch (IOException e3) {
            e3.printStackTrace();
            return -1;
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
            return -1;
        }
    }

    private void N(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Ja);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i3);
            if (index == R.styleable.Ka) {
                M(context, typedArrayObtainStyledAttributes.getResourceId(index, -1));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void O(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.P8);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i3);
            if (index == R.styleable.Q8) {
                int i4 = typedArrayObtainStyledAttributes.getInt(index, this.f32874l);
                this.f32874l = i4;
                if (i4 < 8) {
                    this.f32874l = 8;
                }
            } else if (index == R.styleable.R8) {
                this.f32875m = typedArrayObtainStyledAttributes.getInteger(index, 0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void S(int i3, MotionLayout motionLayout) {
        ConstraintSet constraintSet = (ConstraintSet) this.f32870h.get(i3);
        constraintSet.f33186c = constraintSet.f33185b;
        int i4 = this.f32872j.get(i3);
        if (i4 > 0) {
            S(i4, motionLayout);
            ConstraintSet constraintSet2 = (ConstraintSet) this.f32870h.get(i4);
            if (constraintSet2 == null) {
                Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.c(this.f32863a.getContext(), i4));
                return;
            }
            constraintSet.f33186c += "/" + constraintSet2.f33186c;
            constraintSet.O(constraintSet2);
        } else {
            constraintSet.f33186c += "  layout";
            constraintSet.N(motionLayout);
        }
        constraintSet.h(constraintSet);
    }

    public static String a0(String str) {
        if (str == null) {
            return "";
        }
        int iIndexOf = str.indexOf(47);
        return iIndexOf < 0 ? str : str.substring(iIndexOf + 1);
    }

    private int r(Context context, String str) {
        int identifier;
        if (str.contains("/")) {
            identifier = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.f32873k) {
                System.out.println("id getMap res = " + identifier);
            }
        } else {
            identifier = -1;
        }
        if (identifier == -1) {
            if (str.length() > 1) {
                return Integer.parseInt(str.substring(1));
            }
            Log.e("MotionScene", "error in parsing id");
        }
        return identifier;
    }

    private int y(int i3) {
        int iC;
        StateSet stateSet = this.f32864b;
        return (stateSet == null || (iC = stateSet.c(i3, -1, -1)) == -1) ? i3 : iC;
    }

    float A() {
        Transition transition = this.f32865c;
        if (transition == null || transition.f32896l == null) {
            return 0.0f;
        }
        return this.f32865c.f32896l.l();
    }

    float B() {
        Transition transition = this.f32865c;
        if (transition == null || transition.f32896l == null) {
            return 0.0f;
        }
        return this.f32865c.f32896l.m();
    }

    float C() {
        Transition transition = this.f32865c;
        if (transition == null || transition.f32896l == null) {
            return 0.0f;
        }
        return this.f32865c.f32896l.n();
    }

    float D() {
        Transition transition = this.f32865c;
        if (transition == null || transition.f32896l == null) {
            return 0.0f;
        }
        return this.f32865c.f32896l.o();
    }

    public float E() {
        Transition transition = this.f32865c;
        if (transition != null) {
            return transition.f32893i;
        }
        return 0.0f;
    }

    int F() {
        Transition transition = this.f32865c;
        if (transition == null) {
            return -1;
        }
        return transition.f32888d;
    }

    public Transition G(int i3) {
        ArrayList arrayList = this.f32867e;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            Transition transition = (Transition) obj;
            if (transition.f32885a == i3) {
                return transition;
            }
        }
        return null;
    }

    public List H(int i3) {
        int iY = y(i3);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f32867e;
        int size = arrayList2.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList2.get(i4);
            i4++;
            Transition transition = (Transition) obj;
            if (transition.f32888d == iY || transition.f32887c == iY) {
                arrayList.add(transition);
            }
        }
        return arrayList;
    }

    void P(float f3, float f4) {
        Transition transition = this.f32865c;
        if (transition == null || transition.f32896l == null) {
            return;
        }
        this.f32865c.f32896l.u(f3, f4);
    }

    void Q(float f3, float f4) {
        Transition transition = this.f32865c;
        if (transition == null || transition.f32896l == null) {
            return;
        }
        this.f32865c.f32896l.v(f3, f4);
    }

    void R(MotionEvent motionEvent, int i3, MotionLayout motionLayout) {
        MotionLayout.MotionTracker motionTracker;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.f32879q == null) {
            this.f32879q = this.f32863a.c0();
        }
        this.f32879q.b(motionEvent);
        if (i3 != -1) {
            int action = motionEvent.getAction();
            boolean z2 = false;
            if (action == 0) {
                this.f32882t = motionEvent.getRawX();
                this.f32883u = motionEvent.getRawY();
                this.f32876n = motionEvent;
                this.f32877o = false;
                if (this.f32865c.f32896l != null) {
                    RectF rectFF = this.f32865c.f32896l.f(this.f32863a, rectF);
                    if (rectFF != null && !rectFF.contains(this.f32876n.getX(), this.f32876n.getY())) {
                        this.f32876n = null;
                        this.f32877o = true;
                        return;
                    }
                    RectF rectFP = this.f32865c.f32896l.p(this.f32863a, rectF);
                    if (rectFP == null || rectFP.contains(this.f32876n.getX(), this.f32876n.getY())) {
                        this.f32878p = false;
                    } else {
                        this.f32878p = true;
                    }
                    this.f32865c.f32896l.w(this.f32882t, this.f32883u);
                    return;
                }
                return;
            }
            if (action == 2 && !this.f32877o) {
                float rawY = motionEvent.getRawY() - this.f32883u;
                float rawX = motionEvent.getRawX() - this.f32882t;
                if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent2 = this.f32876n) == null) {
                    return;
                }
                Transition transitionI = i(i3, rawX, rawY, motionEvent2);
                if (transitionI != null) {
                    motionLayout.setTransition(transitionI);
                    RectF rectFP2 = this.f32865c.f32896l.p(this.f32863a, rectF);
                    if (rectFP2 != null && !rectFP2.contains(this.f32876n.getX(), this.f32876n.getY())) {
                        z2 = true;
                    }
                    this.f32878p = z2;
                    this.f32865c.f32896l.z(this.f32882t, this.f32883u);
                }
            }
        }
        if (this.f32877o) {
            return;
        }
        Transition transition = this.f32865c;
        if (transition != null && transition.f32896l != null && !this.f32878p) {
            this.f32865c.f32896l.s(motionEvent, this.f32879q, i3, this);
        }
        this.f32882t = motionEvent.getRawX();
        this.f32883u = motionEvent.getRawY();
        if (motionEvent.getAction() != 1 || (motionTracker = this.f32879q) == null) {
            return;
        }
        motionTracker.a();
        this.f32879q = null;
        int i4 = motionLayout.f32750g;
        if (i4 != -1) {
            h(motionLayout, i4);
        }
    }

    void T(MotionLayout motionLayout) {
        for (int i3 = 0; i3 < this.f32870h.size(); i3++) {
            int iKeyAt = this.f32870h.keyAt(i3);
            if (I(iKeyAt)) {
                Log.e("MotionScene", "Cannot be derived from yourself");
                return;
            }
            S(iKeyAt, motionLayout);
        }
    }

    public void U(int i3, ConstraintSet constraintSet) {
        this.f32870h.put(i3, constraintSet);
    }

    public void V(int i3) {
        Transition transition = this.f32865c;
        if (transition != null) {
            transition.E(i3);
        } else {
            this.f32874l = i3;
        }
    }

    public void W(boolean z2) {
        this.f32880r = z2;
        Transition transition = this.f32865c;
        if (transition == null || transition.f32896l == null) {
            return;
        }
        this.f32865c.f32896l.x(this.f32880r);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void X(int r10, int r11) {
        /*
            r9 = this;
            androidx.constraintlayout.widget.StateSet r0 = r9.f32864b
            r1 = -1
            if (r0 == 0) goto L18
            int r0 = r0.c(r10, r1, r1)
            if (r0 == r1) goto Lc
            goto Ld
        Lc:
            r0 = r10
        Ld:
            androidx.constraintlayout.widget.StateSet r2 = r9.f32864b
            int r2 = r2.c(r11, r1, r1)
            if (r2 == r1) goto L16
            goto L1a
        L16:
            r2 = r11
            goto L1a
        L18:
            r0 = r10
            goto L16
        L1a:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r9.f32865c
            if (r3 == 0) goto L2d
            int r3 = androidx.constraintlayout.motion.widget.MotionScene.Transition.a(r3)
            if (r3 != r11) goto L2d
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r9.f32865c
            int r3 = androidx.constraintlayout.motion.widget.MotionScene.Transition.c(r3)
            if (r3 != r10) goto L2d
            goto L6c
        L2d:
            java.util.ArrayList r3 = r9.f32867e
            int r4 = r3.size()
            r5 = 0
            r6 = r5
        L35:
            if (r6 >= r4) goto L6d
            java.lang.Object r7 = r3.get(r6)
            int r6 = r6 + 1
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r7
            int r8 = androidx.constraintlayout.motion.widget.MotionScene.Transition.a(r7)
            if (r8 != r2) goto L4b
            int r8 = androidx.constraintlayout.motion.widget.MotionScene.Transition.c(r7)
            if (r8 == r0) goto L57
        L4b:
            int r8 = androidx.constraintlayout.motion.widget.MotionScene.Transition.a(r7)
            if (r8 != r11) goto L35
            int r8 = androidx.constraintlayout.motion.widget.MotionScene.Transition.c(r7)
            if (r8 != r10) goto L35
        L57:
            r9.f32865c = r7
            if (r7 == 0) goto L6c
            androidx.constraintlayout.motion.widget.TouchResponse r10 = androidx.constraintlayout.motion.widget.MotionScene.Transition.l(r7)
            if (r10 == 0) goto L6c
            androidx.constraintlayout.motion.widget.MotionScene$Transition r10 = r9.f32865c
            androidx.constraintlayout.motion.widget.TouchResponse r10 = androidx.constraintlayout.motion.widget.MotionScene.Transition.l(r10)
            boolean r11 = r9.f32880r
            r10.x(r11)
        L6c:
            return
        L6d:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r10 = r9.f32868f
            java.util.ArrayList r3 = r9.f32869g
            int r4 = r3.size()
        L75:
            if (r5 >= r4) goto L87
            java.lang.Object r6 = r3.get(r5)
            int r5 = r5 + 1
            androidx.constraintlayout.motion.widget.MotionScene$Transition r6 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r6
            int r7 = androidx.constraintlayout.motion.widget.MotionScene.Transition.a(r6)
            if (r7 != r11) goto L75
            r10 = r6
            goto L75
        L87:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r11 = new androidx.constraintlayout.motion.widget.MotionScene$Transition
            r11.<init>(r9, r10)
            androidx.constraintlayout.motion.widget.MotionScene.Transition.d(r11, r0)
            androidx.constraintlayout.motion.widget.MotionScene.Transition.b(r11, r2)
            if (r0 == r1) goto L99
            java.util.ArrayList r10 = r9.f32867e
            r10.add(r11)
        L99:
            r9.f32865c = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.X(int, int):void");
    }

    public void Y(Transition transition) {
        this.f32865c = transition;
        if (transition == null || transition.f32896l == null) {
            return;
        }
        this.f32865c.f32896l.x(this.f32880r);
    }

    void Z() {
        Transition transition = this.f32865c;
        if (transition == null || transition.f32896l == null) {
            return;
        }
        this.f32865c.f32896l.A();
    }

    boolean b0() {
        ArrayList arrayList = this.f32867e;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            if (((Transition) obj).f32896l != null) {
                return true;
            }
        }
        Transition transition = this.f32865c;
        return (transition == null || transition.f32896l == null) ? false : true;
    }

    public void c0(int i3, View... viewArr) {
        this.f32881s.i(i3, viewArr);
    }

    public void f(MotionLayout motionLayout, int i3) {
        ArrayList arrayList = this.f32867e;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            Transition transition = (Transition) obj;
            if (transition.f32897m.size() > 0) {
                ArrayList arrayList2 = transition.f32897m;
                int size2 = arrayList2.size();
                int i5 = 0;
                while (i5 < size2) {
                    Object obj2 = arrayList2.get(i5);
                    i5++;
                    ((Transition.TransitionOnClick) obj2).c(motionLayout);
                }
            }
        }
        ArrayList arrayList3 = this.f32869g;
        int size3 = arrayList3.size();
        int i6 = 0;
        while (i6 < size3) {
            Object obj3 = arrayList3.get(i6);
            i6++;
            Transition transition2 = (Transition) obj3;
            if (transition2.f32897m.size() > 0) {
                ArrayList arrayList4 = transition2.f32897m;
                int size4 = arrayList4.size();
                int i7 = 0;
                while (i7 < size4) {
                    Object obj4 = arrayList4.get(i7);
                    i7++;
                    ((Transition.TransitionOnClick) obj4).c(motionLayout);
                }
            }
        }
        ArrayList arrayList5 = this.f32867e;
        int size5 = arrayList5.size();
        int i8 = 0;
        while (i8 < size5) {
            Object obj5 = arrayList5.get(i8);
            i8++;
            Transition transition3 = (Transition) obj5;
            if (transition3.f32897m.size() > 0) {
                ArrayList arrayList6 = transition3.f32897m;
                int size6 = arrayList6.size();
                int i9 = 0;
                while (i9 < size6) {
                    Object obj6 = arrayList6.get(i9);
                    i9++;
                    ((Transition.TransitionOnClick) obj6).a(motionLayout, i3, transition3);
                }
            }
        }
        ArrayList arrayList7 = this.f32869g;
        int size7 = arrayList7.size();
        int i10 = 0;
        while (i10 < size7) {
            Object obj7 = arrayList7.get(i10);
            i10++;
            Transition transition4 = (Transition) obj7;
            if (transition4.f32897m.size() > 0) {
                ArrayList arrayList8 = transition4.f32897m;
                int size8 = arrayList8.size();
                int i11 = 0;
                while (i11 < size8) {
                    Object obj8 = arrayList8.get(i11);
                    i11++;
                    ((Transition.TransitionOnClick) obj8).a(motionLayout, i3, transition4);
                }
            }
        }
    }

    public boolean g(int i3, MotionController motionController) {
        return this.f32881s.d(i3, motionController);
    }

    boolean h(MotionLayout motionLayout, int i3) {
        Transition transition;
        if (J() || this.f32866d) {
            return false;
        }
        ArrayList arrayList = this.f32867e;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            Transition transition2 = (Transition) obj;
            if (transition2.f32898n != 0 && ((transition = this.f32865c) != transition2 || !transition.D(2))) {
                if (i3 == transition2.f32888d && (transition2.f32898n == 4 || transition2.f32898n == 2)) {
                    MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(transition2);
                    if (transition2.f32898n == 4) {
                        motionLayout.l0();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.Q(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState);
                        motionLayout.d0();
                    }
                    return true;
                }
                if (i3 == transition2.f32887c && (transition2.f32898n == 3 || transition2.f32898n == 1)) {
                    MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState2);
                    motionLayout.setTransition(transition2);
                    if (transition2.f32898n == 3) {
                        motionLayout.n0();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.Q(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState2);
                        motionLayout.d0();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public Transition i(int i3, float f3, float f4, MotionEvent motionEvent) {
        if (i3 == -1) {
            return this.f32865c;
        }
        List<Transition> listH = H(i3);
        RectF rectF = new RectF();
        float f5 = 0.0f;
        Transition transition = null;
        for (Transition transition2 : listH) {
            if (!transition2.f32899o && transition2.f32896l != null) {
                transition2.f32896l.x(this.f32880r);
                RectF rectFP = transition2.f32896l.p(this.f32863a, rectF);
                if (rectFP == null || motionEvent == null || rectFP.contains(motionEvent.getX(), motionEvent.getY())) {
                    RectF rectFF = transition2.f32896l.f(this.f32863a, rectF);
                    if (rectFF == null || motionEvent == null || rectFF.contains(motionEvent.getX(), motionEvent.getY())) {
                        float fA = transition2.f32896l.a(f3, f4);
                        if (transition2.f32896l.f32917l && motionEvent != null) {
                            fA = ((float) (Math.atan2(f4 + r10, f3 + r9) - Math.atan2(motionEvent.getX() - transition2.f32896l.f32914i, motionEvent.getY() - transition2.f32896l.f32915j))) * 10.0f;
                        }
                        float f6 = fA * (transition2.f32887c == i3 ? -1.0f : 1.1f);
                        if (f6 > f5) {
                            transition = transition2;
                            f5 = f6;
                        }
                    }
                }
            }
        }
        return transition;
    }

    public int j() {
        Transition transition = this.f32865c;
        if (transition != null) {
            return transition.f32900p;
        }
        return -1;
    }

    int k() {
        Transition transition = this.f32865c;
        if (transition == null || transition.f32896l == null) {
            return 0;
        }
        return this.f32865c.f32896l.d();
    }

    ConstraintSet l(int i3) {
        return m(i3, -1, -1);
    }

    ConstraintSet m(int i3, int i4, int i5) {
        int iC;
        if (this.f32873k) {
            System.out.println("id " + i3);
            System.out.println("size " + this.f32870h.size());
        }
        StateSet stateSet = this.f32864b;
        if (stateSet != null && (iC = stateSet.c(i3, i4, i5)) != -1) {
            i3 = iC;
        }
        if (this.f32870h.get(i3) != null) {
            return (ConstraintSet) this.f32870h.get(i3);
        }
        Log.e("MotionScene", "Warning could not find ConstraintSet id/" + Debug.c(this.f32863a.getContext(), i3) + " In MotionScene");
        SparseArray sparseArray = this.f32870h;
        return (ConstraintSet) sparseArray.get(sparseArray.keyAt(0));
    }

    public int[] n() {
        int size = this.f32870h.size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = this.f32870h.keyAt(i3);
        }
        return iArr;
    }

    public ArrayList o() {
        return this.f32867e;
    }

    public int p() {
        Transition transition = this.f32865c;
        return transition != null ? transition.f32892h : this.f32874l;
    }

    int q() {
        Transition transition = this.f32865c;
        if (transition == null) {
            return -1;
        }
        return transition.f32887c;
    }

    public Interpolator s() {
        int i3 = this.f32865c.f32889e;
        if (i3 == -2) {
            return AnimationUtils.loadInterpolator(this.f32863a.getContext(), this.f32865c.f32891g);
        }
        if (i3 == -1) {
            final Easing easingC = Easing.c(this.f32865c.f32890f);
            return new Interpolator(this) { // from class: androidx.constraintlayout.motion.widget.MotionScene.1
                @Override // android.animation.TimeInterpolator
                public float getInterpolation(float f3) {
                    return (float) easingC.a(f3);
                }
            };
        }
        if (i3 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i3 == 1) {
            return new AccelerateInterpolator();
        }
        if (i3 == 2) {
            return new DecelerateInterpolator();
        }
        if (i3 == 4) {
            return new BounceInterpolator();
        }
        if (i3 == 5) {
            return new OvershootInterpolator();
        }
        if (i3 != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    public void t(MotionController motionController) {
        Transition transition = this.f32865c;
        int i3 = 0;
        if (transition != null) {
            ArrayList arrayList = transition.f32895k;
            int size = arrayList.size();
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ((KeyFrames) obj).b(motionController);
            }
            return;
        }
        Transition transition2 = this.f32868f;
        if (transition2 != null) {
            ArrayList arrayList2 = transition2.f32895k;
            int size2 = arrayList2.size();
            while (i3 < size2) {
                Object obj2 = arrayList2.get(i3);
                i3++;
                ((KeyFrames) obj2).b(motionController);
            }
        }
    }

    float u() {
        Transition transition = this.f32865c;
        if (transition == null || transition.f32896l == null) {
            return 0.0f;
        }
        return this.f32865c.f32896l.g();
    }

    float v() {
        Transition transition = this.f32865c;
        if (transition == null || transition.f32896l == null) {
            return 0.0f;
        }
        return this.f32865c.f32896l.h();
    }

    boolean w() {
        Transition transition = this.f32865c;
        if (transition == null || transition.f32896l == null) {
            return false;
        }
        return this.f32865c.f32896l.i();
    }

    float x(float f3, float f4) {
        Transition transition = this.f32865c;
        if (transition == null || transition.f32896l == null) {
            return 0.0f;
        }
        return this.f32865c.f32896l.j(f3, f4);
    }

    int z() {
        Transition transition = this.f32865c;
        if (transition == null || transition.f32896l == null) {
            return 0;
        }
        return this.f32865c.f32896l.k();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Transition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f32885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f32886b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f32887c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f32888d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f32889e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f32890f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f32891g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f32892h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private float f32893i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final MotionScene f32894j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private ArrayList f32895k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private TouchResponse f32896l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private ArrayList f32897m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f32898n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f32899o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f32900p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f32901q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f32902r;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static class TransitionOnClick implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Transition f32903a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f32904b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f32905c;

            public TransitionOnClick(Context context, Transition transition, XmlPullParser xmlPullParser) {
                this.f32904b = -1;
                this.f32905c = 17;
                this.f32903a = transition;
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.T8);
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                for (int i3 = 0; i3 < indexCount; i3++) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i3);
                    if (index == R.styleable.V8) {
                        this.f32904b = typedArrayObtainStyledAttributes.getResourceId(index, this.f32904b);
                    } else if (index == R.styleable.U8) {
                        this.f32905c = typedArrayObtainStyledAttributes.getInt(index, this.f32905c);
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
            }

            public void a(MotionLayout motionLayout, int i3, Transition transition) {
                int i4 = this.f32904b;
                View viewFindViewById = motionLayout;
                if (i4 != -1) {
                    viewFindViewById = motionLayout.findViewById(i4);
                }
                if (viewFindViewById == null) {
                    Log.e("MotionScene", "OnClick could not find id " + this.f32904b);
                    return;
                }
                int i5 = transition.f32888d;
                int i6 = transition.f32887c;
                if (i5 == -1) {
                    viewFindViewById.setOnClickListener(this);
                    return;
                }
                int i7 = this.f32905c;
                boolean z2 = false;
                boolean z3 = ((i7 & 1) != 0 && i3 == i5) | ((i7 & 1) != 0 && i3 == i5) | ((i7 & Function.MAX_NARGS) != 0 && i3 == i5) | ((i7 & 16) != 0 && i3 == i6);
                if ((i7 & 4096) != 0 && i3 == i6) {
                    z2 = true;
                }
                if (z3 || z2) {
                    viewFindViewById.setOnClickListener(this);
                }
            }

            boolean b(Transition transition, MotionLayout motionLayout) {
                Transition transition2 = this.f32903a;
                if (transition2 == transition) {
                    return true;
                }
                int i3 = transition2.f32887c;
                int i4 = this.f32903a.f32888d;
                if (i4 == -1) {
                    return motionLayout.f32750g != i3;
                }
                int i5 = motionLayout.f32750g;
                return i5 == i4 || i5 == i3;
            }

            public void c(MotionLayout motionLayout) {
                int i3 = this.f32904b;
                if (i3 == -1) {
                    return;
                }
                View viewFindViewById = motionLayout.findViewById(i3);
                if (viewFindViewById != null) {
                    viewFindViewById.setOnClickListener(null);
                    return;
                }
                Log.e("MotionScene", " (*)  could not find id " + this.f32904b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MotionLayout motionLayout = this.f32903a.f32894j.f32863a;
                if (motionLayout.b0()) {
                    if (this.f32903a.f32888d == -1) {
                        int currentState = motionLayout.getCurrentState();
                        if (currentState == -1) {
                            motionLayout.o0(this.f32903a.f32887c);
                            return;
                        }
                        Transition transition = new Transition(this.f32903a.f32894j, this.f32903a);
                        transition.f32888d = currentState;
                        transition.f32887c = this.f32903a.f32887c;
                        motionLayout.setTransition(transition);
                        motionLayout.l0();
                        return;
                    }
                    Transition transition2 = this.f32903a.f32894j.f32865c;
                    int i3 = this.f32905c;
                    boolean z2 = false;
                    boolean z3 = ((i3 & 1) == 0 && (i3 & Function.MAX_NARGS) == 0) ? false : true;
                    boolean z4 = ((i3 & 16) == 0 && (i3 & 4096) == 0) ? false : true;
                    if (z3 && z4) {
                        Transition transition3 = this.f32903a.f32894j.f32865c;
                        Transition transition4 = this.f32903a;
                        if (transition3 != transition4) {
                            motionLayout.setTransition(transition4);
                        }
                        if (motionLayout.getCurrentState() != motionLayout.getEndState() && motionLayout.getProgress() <= 0.5f) {
                            z4 = false;
                            z2 = z3;
                        }
                    } else {
                        z2 = z3;
                    }
                    if (b(transition2, motionLayout)) {
                        if (z2 && (this.f32905c & 1) != 0) {
                            motionLayout.setTransition(this.f32903a);
                            motionLayout.l0();
                            return;
                        }
                        if (z4 && (this.f32905c & 16) != 0) {
                            motionLayout.setTransition(this.f32903a);
                            motionLayout.n0();
                        } else if (z2 && (this.f32905c & Function.MAX_NARGS) != 0) {
                            motionLayout.setTransition(this.f32903a);
                            motionLayout.setProgress(1.0f);
                        } else {
                            if (!z4 || (this.f32905c & 4096) == 0) {
                                return;
                            }
                            motionLayout.setTransition(this.f32903a);
                            motionLayout.setProgress(0.0f);
                        }
                    }
                }
            }
        }

        Transition(MotionScene motionScene, Transition transition) {
            this.f32885a = -1;
            this.f32886b = false;
            this.f32887c = -1;
            this.f32888d = -1;
            this.f32889e = 0;
            this.f32890f = null;
            this.f32891g = -1;
            this.f32892h = RCHTTPStatusCodes.BAD_REQUEST;
            this.f32893i = 0.0f;
            this.f32895k = new ArrayList();
            this.f32896l = null;
            this.f32897m = new ArrayList();
            this.f32898n = 0;
            this.f32899o = false;
            this.f32900p = -1;
            this.f32901q = 0;
            this.f32902r = 0;
            this.f32894j = motionScene;
            this.f32892h = motionScene.f32874l;
            if (transition != null) {
                this.f32900p = transition.f32900p;
                this.f32889e = transition.f32889e;
                this.f32890f = transition.f32890f;
                this.f32891g = transition.f32891g;
                this.f32892h = transition.f32892h;
                this.f32895k = transition.f32895k;
                this.f32893i = transition.f32893i;
                this.f32901q = transition.f32901q;
            }
        }

        private void v(MotionScene motionScene, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArray.getIndex(i3);
                if (index == R.styleable.ba) {
                    this.f32887c = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f32887c);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.F(context, this.f32887c);
                        motionScene.f32870h.append(this.f32887c, constraintSet);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.f32887c = motionScene.M(context, this.f32887c);
                    }
                } else if (index == R.styleable.ca) {
                    this.f32888d = typedArray.getResourceId(index, this.f32888d);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.f32888d);
                    if ("layout".equals(resourceTypeName2)) {
                        ConstraintSet constraintSet2 = new ConstraintSet();
                        constraintSet2.F(context, this.f32888d);
                        motionScene.f32870h.append(this.f32888d, constraintSet2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.f32888d = motionScene.M(context, this.f32888d);
                    }
                } else if (index == R.styleable.fa) {
                    int i4 = typedArray.peekValue(index).type;
                    if (i4 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.f32891g = resourceId;
                        if (resourceId != -1) {
                            this.f32889e = -2;
                        }
                    } else if (i4 == 3) {
                        String string = typedArray.getString(index);
                        this.f32890f = string;
                        if (string != null) {
                            if (string.indexOf("/") > 0) {
                                this.f32891g = typedArray.getResourceId(index, -1);
                                this.f32889e = -2;
                            } else {
                                this.f32889e = -1;
                            }
                        }
                    } else {
                        this.f32889e = typedArray.getInteger(index, this.f32889e);
                    }
                } else if (index == R.styleable.da) {
                    int i5 = typedArray.getInt(index, this.f32892h);
                    this.f32892h = i5;
                    if (i5 < 8) {
                        this.f32892h = 8;
                    }
                } else if (index == R.styleable.ha) {
                    this.f32893i = typedArray.getFloat(index, this.f32893i);
                } else if (index == R.styleable.aa) {
                    this.f32898n = typedArray.getInteger(index, this.f32898n);
                } else if (index == R.styleable.Z9) {
                    this.f32885a = typedArray.getResourceId(index, this.f32885a);
                } else if (index == R.styleable.ia) {
                    this.f32899o = typedArray.getBoolean(index, this.f32899o);
                } else if (index == R.styleable.ga) {
                    this.f32900p = typedArray.getInteger(index, -1);
                } else if (index == R.styleable.ea) {
                    this.f32901q = typedArray.getInteger(index, 0);
                } else if (index == R.styleable.ja) {
                    this.f32902r = typedArray.getInteger(index, 0);
                }
            }
            if (this.f32888d == -1) {
                this.f32886b = true;
            }
        }

        private void w(MotionScene motionScene, Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Y9);
            v(motionScene, context, typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
        }

        public int A() {
            return this.f32888d;
        }

        public TouchResponse B() {
            return this.f32896l;
        }

        public boolean C() {
            return !this.f32899o;
        }

        public boolean D(int i3) {
            return (i3 & this.f32902r) != 0;
        }

        public void E(int i3) {
            this.f32892h = Math.max(i3, 8);
        }

        public void F(boolean z2) {
            this.f32899o = !z2;
        }

        public void G(int i3, String str, int i4) {
            this.f32889e = i3;
            this.f32890f = str;
            this.f32891g = i4;
        }

        public void H(int i3) {
            TouchResponse touchResponseB = B();
            if (touchResponseB != null) {
                touchResponseB.y(i3);
            }
        }

        public void I(int i3) {
            this.f32900p = i3;
        }

        public void t(KeyFrames keyFrames) {
            this.f32895k.add(keyFrames);
        }

        public void u(Context context, XmlPullParser xmlPullParser) {
            this.f32897m.add(new TransitionOnClick(context, this, xmlPullParser));
        }

        public int x() {
            return this.f32898n;
        }

        public int y() {
            return this.f32887c;
        }

        public int z() {
            return this.f32901q;
        }

        public Transition(int i3, MotionScene motionScene, int i4, int i5) {
            this.f32885a = -1;
            this.f32886b = false;
            this.f32887c = -1;
            this.f32888d = -1;
            this.f32889e = 0;
            this.f32890f = null;
            this.f32891g = -1;
            this.f32892h = RCHTTPStatusCodes.BAD_REQUEST;
            this.f32893i = 0.0f;
            this.f32895k = new ArrayList();
            this.f32896l = null;
            this.f32897m = new ArrayList();
            this.f32898n = 0;
            this.f32899o = false;
            this.f32900p = -1;
            this.f32901q = 0;
            this.f32902r = 0;
            this.f32885a = i3;
            this.f32894j = motionScene;
            this.f32888d = i4;
            this.f32887c = i5;
            this.f32892h = motionScene.f32874l;
            this.f32901q = motionScene.f32875m;
        }

        Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
            this.f32885a = -1;
            this.f32886b = false;
            this.f32887c = -1;
            this.f32888d = -1;
            this.f32889e = 0;
            this.f32890f = null;
            this.f32891g = -1;
            this.f32892h = RCHTTPStatusCodes.BAD_REQUEST;
            this.f32893i = 0.0f;
            this.f32895k = new ArrayList();
            this.f32896l = null;
            this.f32897m = new ArrayList();
            this.f32898n = 0;
            this.f32899o = false;
            this.f32900p = -1;
            this.f32901q = 0;
            this.f32902r = 0;
            this.f32892h = motionScene.f32874l;
            this.f32901q = motionScene.f32875m;
            this.f32894j = motionScene;
            w(motionScene, context, Xml.asAttributeSet(xmlPullParser));
        }
    }
}
