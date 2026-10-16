package com.borax12.materialdaterangepicker.time;

import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;
import com.borax12.materialdaterangepicker.HapticFeedbackController;
import com.borax12.materialdaterangepicker.R;
import com.borax12.materialdaterangepicker.Utils;
import com.borax12.materialdaterangepicker.time.RadialPickerLayout;
import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class TimePickerDialog extends DialogFragment implements RadialPickerLayout.OnValueSelectedListener {
    private boolean A;
    private int B = -1;
    private boolean C;
    private char D;
    private String E;
    private String F;
    private boolean G;
    private ArrayList H;
    private Node I;
    private int J;
    private int K;
    private String L;
    private String M;
    private String N;
    private String O;
    private TabHost P;
    private TextView Q;
    private TextView R;
    private TextView S;
    private TextView T;
    private TextView U;
    private RadialPickerLayout V;
    private View W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OnTimeSetListener f65990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DialogInterface.OnCancelListener f65991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DialogInterface.OnDismissListener f65992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HapticFeedbackController f65993d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Button f65994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Button f65995g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f65996h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f65997i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f65998j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f65999k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f66000l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f66001m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private RadialPickerLayout f66002n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f66003o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f66004p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f66005q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f66006r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f66007s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f66008t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f66009u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Integer f66010v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Integer f66011w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f66012x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f66013y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f66014z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class KeyboardListener implements View.OnKeyListener {
        private KeyboardListener() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 1) {
                return TimePickerDialog.this.T(i3);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Node {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int[] f66025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArrayList f66026b = new ArrayList();

        public Node(int... iArr) {
            this.f66025a = iArr;
        }

        public void a(Node node) {
            this.f66026b.add(node);
        }

        public Node b(int i3) {
            ArrayList arrayList = this.f66026b;
            if (arrayList == null) {
                return null;
            }
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                Node node = (Node) obj;
                if (node.c(i3)) {
                    return node;
                }
            }
            return null;
        }

        public boolean c(int i3) {
            int i4 = 0;
            while (true) {
                int[] iArr = this.f66025a;
                if (i4 >= iArr.length) {
                    return false;
                }
                if (iArr[i4] == i3) {
                    return true;
                }
                i4++;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnTimeSetListener {
        void a(RadialPickerLayout radialPickerLayout, int i3, int i4, int i5, int i6);
    }

    private boolean J(int i3) {
        if ((this.f66012x && this.H.size() == 4) || (!this.f66012x && R())) {
            return false;
        }
        this.H.add(Integer.valueOf(i3));
        if (!S()) {
            L();
            return false;
        }
        int iQ = Q(i3);
        if (this.P.getCurrentTab() == 0) {
            Utils.e(this.f66002n, String.format("%d", Integer.valueOf(iQ)));
        } else {
            Utils.e(this.V, String.format("%d", Integer.valueOf(iQ)));
        }
        if (R()) {
            if (!this.f66012x && this.H.size() <= 3) {
                ArrayList arrayList = this.H;
                arrayList.add(arrayList.size() - 1, 7);
                ArrayList arrayList2 = this.H;
                arrayList2.add(arrayList2.size() - 1, 7);
            }
            this.f65995g.setEnabled(true);
        }
        return true;
    }

    private int L() {
        int iIntValue = ((Integer) this.H.remove(r0.size() - 1)).intValue();
        if (!R()) {
            this.f65995g.setEnabled(false);
        }
        return iIntValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(boolean z2) {
        this.G = false;
        if (!this.H.isEmpty()) {
            int[] iArrP = P(null);
            if (this.P.getCurrentTab() == 0) {
                this.f66002n.p(iArrP[0], iArrP[1]);
                if (!this.f66012x) {
                    this.f66002n.setAmOrPm(iArrP[2]);
                }
            } else {
                this.V.p(iArrP[0], iArrP[1]);
                if (!this.f66012x) {
                    this.V.setAmOrPm(iArrP[2]);
                }
            }
            this.H.clear();
        }
        if (z2) {
            a0(false);
            if (this.P.getCurrentTab() == 0) {
                this.f66002n.t(true);
            } else {
                this.V.t(true);
            }
        }
    }

    private void N() {
        this.I = new Node(new int[0]);
        if (this.f66012x) {
            Node node = new Node(7, 8, 9, 10, 11, 12);
            Node node2 = new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
            node.a(node2);
            Node node3 = new Node(7, 8);
            this.I.a(node3);
            Node node4 = new Node(7, 8, 9, 10, 11, 12);
            node3.a(node4);
            node4.a(node);
            node4.a(new Node(13, 14, 15, 16));
            Node node5 = new Node(13, 14, 15, 16);
            node3.a(node5);
            node5.a(node);
            Node node6 = new Node(9);
            this.I.a(node6);
            Node node7 = new Node(7, 8, 9, 10);
            node6.a(node7);
            node7.a(node);
            Node node8 = new Node(11, 12);
            node6.a(node8);
            node8.a(node2);
            Node node9 = new Node(10, 11, 12, 13, 14, 15, 16);
            this.I.a(node9);
            node9.a(node);
            return;
        }
        Node node10 = new Node(O(0), O(1));
        Node node11 = new Node(8);
        this.I.a(node11);
        node11.a(node10);
        Node node12 = new Node(7, 8, 9);
        node11.a(node12);
        node12.a(node10);
        Node node13 = new Node(7, 8, 9, 10, 11, 12);
        node12.a(node13);
        node13.a(node10);
        Node node14 = new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        node13.a(node14);
        node14.a(node10);
        Node node15 = new Node(13, 14, 15, 16);
        node12.a(node15);
        node15.a(node10);
        Node node16 = new Node(10, 11, 12);
        node11.a(node16);
        Node node17 = new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        node16.a(node17);
        node17.a(node10);
        Node node18 = new Node(9, 10, 11, 12, 13, 14, 15, 16);
        this.I.a(node18);
        node18.a(node10);
        Node node19 = new Node(7, 8, 9, 10, 11, 12);
        node18.a(node19);
        Node node20 = new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        node19.a(node20);
        node20.a(node10);
    }

    private int O(int i3) {
        if (this.J == -1 || this.K == -1) {
            KeyCharacterMap keyCharacterMapLoad = KeyCharacterMap.load(-1);
            int i4 = 0;
            while (true) {
                if (i4 >= Math.max(this.f66005q.length(), this.f66006r.length())) {
                    break;
                }
                char cCharAt = this.f66005q.toLowerCase(Locale.getDefault()).charAt(i4);
                char cCharAt2 = this.f66006r.toLowerCase(Locale.getDefault()).charAt(i4);
                if (cCharAt != cCharAt2) {
                    KeyEvent[] events = keyCharacterMapLoad.getEvents(new char[]{cCharAt, cCharAt2});
                    if (events == null || events.length != 4) {
                        Log.e("TimePickerDialog", "Unable to find keycodes for AM and PM.");
                    } else {
                        this.J = events[0].getKeyCode();
                        this.K = events[2].getKeyCode();
                    }
                } else {
                    i4++;
                }
            }
        }
        if (i3 == 0) {
            return this.J;
        }
        if (i3 == 1) {
            return this.K;
        }
        return -1;
    }

    private int[] P(Boolean[] boolArr) {
        int i3;
        int i4;
        int i5 = -1;
        if (this.f66012x || !R()) {
            i3 = -1;
            i4 = 1;
        } else {
            ArrayList arrayList = this.H;
            int iIntValue = ((Integer) arrayList.get(arrayList.size() - 1)).intValue();
            i3 = iIntValue == O(0) ? 0 : iIntValue == O(1) ? 1 : -1;
            i4 = 2;
        }
        int i6 = -1;
        for (int i7 = i4; i7 <= this.H.size(); i7++) {
            ArrayList arrayList2 = this.H;
            int iQ = Q(((Integer) arrayList2.get(arrayList2.size() - i7)).intValue());
            if (i7 == i4) {
                i6 = iQ;
            } else if (i7 == i4 + 1) {
                i6 += iQ * 10;
                if (boolArr != null && iQ == 0) {
                    boolArr[1] = Boolean.TRUE;
                }
            } else if (i7 == i4 + 2) {
                i5 = iQ;
            } else if (i7 == i4 + 3) {
                i5 += iQ * 10;
                if (boolArr != null && iQ == 0) {
                    boolArr[0] = Boolean.TRUE;
                }
            }
        }
        return new int[]{i5, i6, i3};
    }

    private static int Q(int i3) {
        switch (i3) {
            case 7:
                return 0;
            case 8:
                return 1;
            case 9:
                return 2;
            case 10:
                return 3;
            case 11:
                return 4;
            case 12:
                return 5;
            case 13:
                return 6;
            case 14:
                return 7;
            case 15:
                return 8;
            case 16:
                return 9;
            default:
                return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean R() {
        int i3;
        if (!this.f66012x) {
            return this.H.contains(Integer.valueOf(O(0))) || this.H.contains(Integer.valueOf(O(1)));
        }
        int[] iArrP = P(null);
        return iArrP[0] >= 0 && (i3 = iArrP[1]) >= 0 && i3 < 60;
    }

    private boolean S() {
        Node nodeB = this.I;
        ArrayList arrayList = this.H;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            nodeB = nodeB.b(((Integer) obj).intValue());
            if (nodeB == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean T(int i3) {
        if (i3 == 111 || i3 == 4) {
            if (isCancelable()) {
                dismiss();
            }
            return true;
        }
        if (i3 == 61) {
            if (this.G) {
                if (R()) {
                    M(true);
                }
                return true;
            }
        } else {
            if (i3 == 66) {
                if (this.G) {
                    if (!R()) {
                        return true;
                    }
                    M(false);
                }
                OnTimeSetListener onTimeSetListener = this.f65990a;
                if (onTimeSetListener != null) {
                    RadialPickerLayout radialPickerLayout = this.f66002n;
                    onTimeSetListener.a(radialPickerLayout, radialPickerLayout.getHours(), this.f66002n.getMinutes(), this.V.getHours(), this.V.getMinutes());
                }
                dismiss();
                return true;
            }
            if (i3 == 67) {
                if (this.G && !this.H.isEmpty()) {
                    int iL = L();
                    String str = iL == O(0) ? this.f66005q : iL == O(1) ? this.f66006r : String.format("%d", Integer.valueOf(Q(iL)));
                    if (this.P.getCurrentTab() == 0) {
                        Utils.e(this.f66002n, String.format(this.F, str));
                    } else {
                        Utils.e(this.V, String.format(this.F, str));
                    }
                    a0(true);
                }
            } else if (i3 == 7 || i3 == 8 || i3 == 9 || i3 == 10 || i3 == 11 || i3 == 12 || i3 == 13 || i3 == 14 || i3 == 15 || i3 == 16 || (!this.f66012x && (i3 == O(0) || i3 == O(1)))) {
                if (this.G) {
                    if (J(i3)) {
                        a0(false);
                    }
                    return true;
                }
                if (this.f66002n == null) {
                    Log.e("TimePickerDialog", "Unable to initiate keyboard mode, TimePicker was null.");
                    return true;
                }
                this.H.clear();
                X(i3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i3, boolean z2, boolean z3, boolean z4) {
        TextView textView;
        TextView textView2;
        if (this.P.getCurrentTab() == 0) {
            this.f66002n.m(i3, z2);
            if (i3 == 0) {
                int hours = this.f66002n.getHours();
                if (!this.f66012x) {
                    hours %= 12;
                }
                this.f66002n.setContentDescription(this.L + ": " + hours);
                if (z4) {
                    Utils.e(this.f66002n, this.M);
                }
                textView2 = this.f65996h;
            } else {
                int minutes = this.f66002n.getMinutes();
                this.f66002n.setContentDescription(this.N + ": " + minutes);
                if (z4) {
                    Utils.e(this.f66002n, this.O);
                }
                textView2 = this.f65998j;
            }
            int i4 = i3 == 0 ? this.f66003o : this.f66004p;
            int i5 = i3 == 1 ? this.f66003o : this.f66004p;
            this.f65996h.setTextColor(i4);
            this.f65998j.setTextColor(i5);
            ObjectAnimator objectAnimatorC = Utils.c(textView2, 0.85f, 1.1f);
            if (z3) {
                objectAnimatorC.setStartDelay(300L);
            }
            objectAnimatorC.start();
            return;
        }
        this.V.m(i3, z2);
        if (i3 == 0) {
            int hours2 = this.V.getHours();
            if (!this.f66012x) {
                hours2 %= 12;
            }
            this.V.setContentDescription(this.L + ": " + hours2);
            if (z4) {
                Utils.e(this.V, this.M);
            }
            textView = this.Q;
        } else {
            int minutes2 = this.V.getMinutes();
            this.V.setContentDescription(this.N + ": " + minutes2);
            if (z4) {
                Utils.e(this.V, this.O);
            }
            textView = this.T;
        }
        int i6 = i3 == 0 ? this.f66003o : this.f66004p;
        int i7 = i3 == 1 ? this.f66003o : this.f66004p;
        this.Q.setTextColor(i6);
        this.T.setTextColor(i7);
        ObjectAnimator objectAnimatorC2 = Utils.c(textView, 0.85f, 1.1f);
        if (z3) {
            objectAnimatorC2.setStartDelay(300L);
        }
        objectAnimatorC2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i3, boolean z2) {
        String str;
        if (this.f66012x) {
            str = "%02d";
        } else {
            i3 %= 12;
            str = "%d";
            if (i3 == 0) {
                i3 = 12;
            }
        }
        String str2 = String.format(str, Integer.valueOf(i3));
        if (this.P.getCurrentTab() == 0) {
            this.f65996h.setText(str2);
            this.f65997i.setText(str2);
            if (z2) {
                Utils.e(this.f66002n, str2);
                return;
            }
            return;
        }
        this.Q.setText(str2);
        this.R.setText(str2);
        if (z2) {
            Utils.e(this.V, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(int i3) {
        if (i3 == 60) {
            i3 = 0;
        }
        String str = String.format(Locale.getDefault(), "%02d", Integer.valueOf(i3));
        if (this.P.getCurrentTab() == 0) {
            Utils.e(this.f66002n, str);
            this.f65998j.setText(str);
            this.f65999k.setText(str);
        } else {
            Utils.e(this.V, str);
            this.T.setText(str);
            this.S.setText(str);
        }
    }

    private void X(int i3) {
        if (this.f66002n.t(false)) {
            if (i3 == -1 || J(i3)) {
                this.G = true;
                this.f65995g.setEnabled(false);
                a0(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i3) {
        if (i3 == 0) {
            if (this.P.getCurrentTab() == 0) {
                this.f66000l.setText(this.f66005q);
                this.f66001m.setContentDescription(this.f66005q);
                Utils.e(this.f66002n, this.f66005q);
                return;
            } else {
                this.U.setText(this.f66005q);
                this.W.setContentDescription(this.f66005q);
                Utils.e(this.V, this.f66005q);
                return;
            }
        }
        if (i3 != 1) {
            if (this.P.getCurrentTab() == 0) {
                this.f66000l.setText(this.E);
                return;
            } else {
                this.U.setText(this.E);
                return;
            }
        }
        if (this.P.getCurrentTab() == 0) {
            this.f66000l.setText(this.f66006r);
            this.f66001m.setContentDescription(this.f66006r);
            Utils.e(this.f66002n, this.f66006r);
        } else {
            this.U.setText(this.f66006r);
            this.W.setContentDescription(this.f66006r);
            Utils.e(this.V, this.f66006r);
        }
    }

    private void a0(boolean z2) {
        if (!z2 && this.H.isEmpty()) {
            if (this.P.getCurrentTab() == 0) {
                int hours = this.f66002n.getHours();
                int minutes = this.f66002n.getMinutes();
                V(hours, true);
                W(minutes);
                if (!this.f66012x) {
                    Z(hours >= 12 ? 1 : 0);
                }
                U(this.f66002n.getCurrentItemShowing(), true, true, true);
            } else {
                int hours2 = this.V.getHours();
                int minutes2 = this.V.getMinutes();
                V(hours2, true);
                W(minutes2);
                if (!this.f66012x) {
                    Z(hours2 >= 12 ? 1 : 0);
                }
                U(this.V.getCurrentItemShowing(), true, true, true);
            }
            this.f65995g.setEnabled(true);
            return;
        }
        Boolean bool = Boolean.FALSE;
        Boolean[] boolArr = {bool, bool};
        int[] iArrP = P(boolArr);
        String str = boolArr[0].booleanValue() ? "%02d" : "%2d";
        String str2 = boolArr[1].booleanValue() ? "%02d" : "%2d";
        int i3 = iArrP[0];
        String strReplace = i3 == -1 ? this.E : String.format(str, Integer.valueOf(i3)).replace(' ', this.D);
        int i4 = iArrP[1];
        String strReplace2 = i4 == -1 ? this.E : String.format(str2, Integer.valueOf(i4)).replace(' ', this.D);
        if (this.P.getCurrentTab() == 0) {
            this.f65996h.setText(strReplace);
            this.f65997i.setText(strReplace);
            this.f65996h.setTextColor(this.f66004p);
            this.f65998j.setText(strReplace2);
            this.f65999k.setText(strReplace2);
            this.f65998j.setTextColor(this.f66004p);
        } else {
            this.Q.setText(strReplace);
            this.R.setText(strReplace);
            this.Q.setTextColor(this.f66004p);
            this.T.setText(strReplace2);
            this.S.setText(strReplace2);
            this.T.setTextColor(this.f66004p);
        }
        if (this.f66012x) {
            return;
        }
        Z(iArrP[2]);
    }

    public void Y() {
        if (this.A) {
            this.f65993d.h();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        DialogInterface.OnCancelListener onCancelListener = this.f65991b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && bundle.containsKey("hour_of_day") && bundle.containsKey("minute") && bundle.containsKey("is_24_hour_view")) {
            this.f66008t = bundle.getInt("hour_of_day");
            this.f66009u = bundle.getInt("minute");
            this.f66012x = bundle.getBoolean("is_24_hour_view");
            this.G = bundle.getBoolean("in_kb_mode");
            this.f66013y = bundle.getString("dialog_title");
            this.f66014z = bundle.getBoolean("dark_theme");
            this.B = bundle.getInt("accent");
            this.A = bundle.getBoolean("vibrate");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int iB;
        getDialog().getWindow().requestFeature(1);
        Typeface typefaceI = ResourcesCompat.i(getActivity(), R.font.f65698a);
        View viewInflate = layoutInflater.inflate(R.layout.f65726b, (ViewGroup) null);
        KeyboardListener keyboardListener = new KeyboardListener();
        int i3 = R.id.I;
        viewInflate.findViewById(i3).setOnKeyListener(keyboardListener);
        Resources resources = getResources();
        this.L = resources.getString(R.string.f65735g);
        this.M = resources.getString(R.string.f65742n);
        this.N = resources.getString(R.string.f65737i);
        this.O = resources.getString(R.string.f65743o);
        this.f66003o = resources.getColor(this.f66014z ? R.color.f65686t : R.color.f65689w);
        this.f66004p = resources.getColor(R.color.f65669c);
        int i4 = R.id.F;
        TabHost tabHost = (TabHost) viewInflate.findViewById(i4);
        this.P = tabHost;
        tabHost.findViewById(i4);
        this.P.setup();
        TabHost.TabSpec tabSpecNewTabSpec = this.P.newTabSpec("start");
        tabSpecNewTabSpec.setContent(R.id.E);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getActivity());
        int i5 = R.layout.f65728d;
        View viewInflate2 = layoutInflaterFrom.inflate(i5, (ViewGroup) null);
        int i6 = R.id.G;
        ((TextView) viewInflate2.findViewById(i6)).setText(R.string.f65729a);
        tabSpecNewTabSpec.setIndicator(viewInflate2);
        TabHost.TabSpec tabSpecNewTabSpec2 = this.P.newTabSpec("end");
        tabSpecNewTabSpec2.setContent(R.id.f65717s);
        View viewInflate3 = LayoutInflater.from(getActivity()).inflate(i5, (ViewGroup) null);
        ((TextView) viewInflate3.findViewById(i6)).setText(R.string.f65751w);
        tabSpecNewTabSpec2.setIndicator(viewInflate3);
        this.P.addTab(tabSpecNewTabSpec);
        this.P.addTab(tabSpecNewTabSpec2);
        TextView textView = (TextView) viewInflate.findViewById(R.id.f65720v);
        this.f65996h = textView;
        textView.setOnKeyListener(keyboardListener);
        this.f65996h.setTypeface(typefaceI);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.f65721w);
        this.Q = textView2;
        textView2.setOnKeyListener(keyboardListener);
        this.Q.setTypeface(typefaceI);
        this.f65997i = (TextView) viewInflate.findViewById(R.id.f65718t);
        this.R = (TextView) viewInflate.findViewById(R.id.f65719u);
        this.f65999k = (TextView) viewInflate.findViewById(R.id.f65724z);
        this.S = (TextView) viewInflate.findViewById(R.id.A);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.f65722x);
        this.f65998j = textView3;
        textView3.setTypeface(typefaceI);
        this.f65998j.setOnKeyListener(keyboardListener);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.f65723y);
        this.T = textView4;
        textView4.setTypeface(typefaceI);
        this.T.setOnKeyListener(keyboardListener);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.f65701c);
        this.f66000l = textView5;
        textView5.setOnKeyListener(keyboardListener);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.f65702d);
        this.U = textView6;
        textView6.setOnKeyListener(keyboardListener);
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        this.f66005q = amPmStrings[0];
        this.f66006r = amPmStrings[1];
        this.f65993d = new HapticFeedbackController(getActivity());
        RadialPickerLayout radialPickerLayout = (RadialPickerLayout) viewInflate.findViewById(R.id.H);
        this.f66002n = radialPickerLayout;
        radialPickerLayout.setOnValueSelectedListener(this);
        this.f66002n.setOnKeyListener(keyboardListener);
        this.f66002n.i(getActivity(), this, this.f66008t, this.f66009u, this.f66012x);
        RadialPickerLayout radialPickerLayout2 = (RadialPickerLayout) viewInflate.findViewById(R.id.J);
        this.V = radialPickerLayout2;
        radialPickerLayout2.setOnValueSelectedListener(this);
        this.V.setOnKeyListener(keyboardListener);
        if (this.f66011w == null || this.f66010v == null) {
            this.V.i(getActivity(), this, this.f66008t, this.f66009u, this.f66012x);
        } else {
            this.V.i(getActivity(), this, this.f66010v.intValue(), this.f66011w.intValue(), this.f66012x);
        }
        int i7 = (bundle == null || !bundle.containsKey("current_item_showing")) ? 0 : bundle.getInt("current_item_showing");
        int i8 = (bundle == null || !bundle.containsKey("current_item_showing_end")) ? 0 : bundle.getInt("current_item_showing_end");
        U(i7, false, true, true);
        U(i8, false, true, true);
        this.f66002n.invalidate();
        this.V.invalidate();
        this.f65996h.setOnClickListener(new View.OnClickListener() { // from class: com.borax12.materialdaterangepicker.time.TimePickerDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TimePickerDialog.this.U(0, true, false, true);
                TimePickerDialog.this.Y();
            }
        });
        this.Q.setOnClickListener(new View.OnClickListener() { // from class: com.borax12.materialdaterangepicker.time.TimePickerDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TimePickerDialog.this.U(0, true, false, true);
                TimePickerDialog.this.Y();
            }
        });
        this.f65998j.setOnClickListener(new View.OnClickListener() { // from class: com.borax12.materialdaterangepicker.time.TimePickerDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TimePickerDialog.this.U(1, true, false, true);
                TimePickerDialog.this.Y();
            }
        });
        this.T.setOnClickListener(new View.OnClickListener() { // from class: com.borax12.materialdaterangepicker.time.TimePickerDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TimePickerDialog.this.U(1, true, false, true);
                TimePickerDialog.this.Y();
            }
        });
        Button button = (Button) viewInflate.findViewById(R.id.B);
        this.f65995g = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.borax12.materialdaterangepicker.time.TimePickerDialog.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TimePickerDialog.this.G && TimePickerDialog.this.R()) {
                    TimePickerDialog.this.M(false);
                } else {
                    TimePickerDialog.this.Y();
                }
                if (TimePickerDialog.this.f65990a != null) {
                    int hours = TimePickerDialog.this.f66002n.getHours();
                    int hours2 = TimePickerDialog.this.V.getHours();
                    int minutes = TimePickerDialog.this.f66002n.getMinutes();
                    int minutes2 = TimePickerDialog.this.V.getMinutes();
                    if (hours == hours2 && minutes == minutes2) {
                        Toast.makeText(TimePickerDialog.this.f66002n.getContext(), TimePickerDialog.this.getResources().getString(R.string.f65752x), 0).show();
                    } else {
                        TimePickerDialog.this.f65990a.a(TimePickerDialog.this.f66002n, TimePickerDialog.this.f66002n.getHours(), TimePickerDialog.this.f66002n.getMinutes(), TimePickerDialog.this.V.getHours(), TimePickerDialog.this.V.getMinutes());
                        TimePickerDialog.this.dismiss();
                    }
                }
            }
        });
        this.f65995g.setOnKeyListener(keyboardListener);
        this.f65995g.setTypeface(typefaceI);
        Button button2 = (Button) viewInflate.findViewById(R.id.f65705g);
        this.f65994f = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.borax12.materialdaterangepicker.time.TimePickerDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TimePickerDialog.this.Y();
                if (TimePickerDialog.this.getDialog() != null) {
                    TimePickerDialog.this.getDialog().cancel();
                }
            }
        });
        this.f65994f.setTypeface(typefaceI);
        this.f65994f.setVisibility(isCancelable() ? 0 : 8);
        this.f66001m = viewInflate.findViewById(R.id.f65699a);
        this.W = viewInflate.findViewById(R.id.f65700b);
        if (this.f66012x) {
            this.f66000l.setVisibility(8);
            this.U.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            TextView textView7 = (TextView) viewInflate.findViewById(R.id.C);
            textView7.setTypeface(typefaceI);
            TextView textView8 = (TextView) viewInflate.findViewById(R.id.D);
            textView8.setTypeface(typefaceI);
            textView7.setLayoutParams(layoutParams);
            textView8.setLayoutParams(layoutParams);
        } else {
            this.f66000l.setVisibility(0);
            this.U.setVisibility(0);
            Z(this.f66008t < 12 ? 0 : 1);
            this.f66001m.setOnClickListener(new View.OnClickListener() { // from class: com.borax12.materialdaterangepicker.time.TimePickerDialog.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TimePickerDialog.this.Y();
                    int isCurrentlyAmOrPm = TimePickerDialog.this.f66002n.getIsCurrentlyAmOrPm();
                    if (isCurrentlyAmOrPm == 0) {
                        isCurrentlyAmOrPm = 1;
                    } else if (isCurrentlyAmOrPm == 1) {
                        isCurrentlyAmOrPm = 0;
                    }
                    TimePickerDialog.this.Z(isCurrentlyAmOrPm);
                    TimePickerDialog.this.f66002n.setAmOrPm(isCurrentlyAmOrPm);
                }
            });
            this.W.setOnClickListener(new View.OnClickListener() { // from class: com.borax12.materialdaterangepicker.time.TimePickerDialog.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TimePickerDialog.this.Y();
                    int isCurrentlyAmOrPm = TimePickerDialog.this.V.getIsCurrentlyAmOrPm();
                    if (isCurrentlyAmOrPm == 0) {
                        isCurrentlyAmOrPm = 1;
                    } else if (isCurrentlyAmOrPm == 1) {
                        isCurrentlyAmOrPm = 0;
                    }
                    TimePickerDialog.this.Z(isCurrentlyAmOrPm);
                    TimePickerDialog.this.V.setAmOrPm(isCurrentlyAmOrPm);
                }
            });
        }
        this.f66007s = true;
        V(this.f66008t, true);
        W(this.f66009u);
        this.E = resources.getString(R.string.f65749u);
        this.F = resources.getString(R.string.f65734f);
        this.D = this.E.charAt(0);
        this.K = -1;
        this.J = -1;
        N();
        if (this.G) {
            this.H = bundle.getIntegerArrayList("typed_times");
            X(-1);
            this.f65996h.invalidate();
            this.Q.invalidate();
        } else if (this.H == null) {
            this.H = new ArrayList();
        }
        TextView textView9 = (TextView) viewInflate.findViewById(R.id.K);
        TextView textView10 = (TextView) viewInflate.findViewById(R.id.L);
        if (!this.f66013y.isEmpty()) {
            textView9.setVisibility(0);
            textView9.setText(this.f66013y);
            textView10.setVisibility(0);
            textView10.setText(this.f66013y);
        }
        this.f66002n.o(getActivity().getApplicationContext(), this.f66014z);
        this.V.o(getActivity().getApplicationContext(), this.f66014z);
        if (this.B == -1 && (iB = Utils.b(getActivity())) != -1) {
            this.B = iB;
        }
        int color = resources.getColor(R.color.f65672f);
        int color2 = resources.getColor(R.color.f65671e);
        int i9 = R.color.f65685s;
        int color3 = resources.getColor(i9);
        int color4 = resources.getColor(i9);
        this.f66002n.setBackgroundColor(this.f66014z ? color4 : color);
        RadialPickerLayout radialPickerLayout3 = this.V;
        if (this.f66014z) {
            color = color4;
        }
        radialPickerLayout3.setBackgroundColor(color);
        View viewFindViewById = viewInflate.findViewById(i3);
        if (this.f66014z) {
            color2 = color3;
        }
        viewFindViewById.setBackgroundColor(color2);
        this.P.setOnTabChangedListener(new TabHost.OnTabChangeListener() { // from class: com.borax12.materialdaterangepicker.time.TimePickerDialog.9
            @Override // android.widget.TabHost.OnTabChangeListener
            public void onTabChanged(String str) {
                if (str == "start") {
                    TimePickerDialog timePickerDialog = TimePickerDialog.this;
                    timePickerDialog.U(timePickerDialog.f66002n.getCurrentItemShowing(), true, false, true);
                    TimePickerDialog timePickerDialog2 = TimePickerDialog.this;
                    timePickerDialog2.V(timePickerDialog2.f66002n.getHours(), false);
                    TimePickerDialog timePickerDialog3 = TimePickerDialog.this;
                    timePickerDialog3.W(timePickerDialog3.f66002n.getMinutes());
                    TimePickerDialog timePickerDialog4 = TimePickerDialog.this;
                    timePickerDialog4.Z(timePickerDialog4.f66002n.getIsCurrentlyAmOrPm());
                    return;
                }
                TimePickerDialog timePickerDialog5 = TimePickerDialog.this;
                timePickerDialog5.U(timePickerDialog5.V.getCurrentItemShowing(), true, false, true);
                TimePickerDialog timePickerDialog6 = TimePickerDialog.this;
                timePickerDialog6.V(timePickerDialog6.V.getHours(), false);
                TimePickerDialog timePickerDialog7 = TimePickerDialog.this;
                timePickerDialog7.W(timePickerDialog7.V.getMinutes());
                TimePickerDialog timePickerDialog8 = TimePickerDialog.this;
                timePickerDialog8.Z(timePickerDialog8.V.getIsCurrentlyAmOrPm());
            }
        });
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.f65992c;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f65993d.g();
        if (this.C) {
            dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f65993d.f();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        RadialPickerLayout radialPickerLayout = this.f66002n;
        if (radialPickerLayout != null) {
            bundle.putInt("hour_of_day", radialPickerLayout.getHours());
            bundle.putInt("minute", this.f66002n.getMinutes());
            bundle.putInt("hour_of_day_end", this.V.getHours());
            bundle.putInt("minute_end", this.V.getMinutes());
            bundle.putBoolean("is_24_hour_view", this.f66012x);
            bundle.putInt("current_item_showing", this.f66002n.getCurrentItemShowing());
            bundle.putInt("current_item_showing_end", this.V.getCurrentItemShowing());
            bundle.putBoolean("in_kb_mode", this.G);
            if (this.G) {
                bundle.putIntegerArrayList("typed_times", this.H);
            }
            bundle.putString("dialog_title", this.f66013y);
            bundle.putBoolean("dark_theme", this.f66014z);
            bundle.putInt("accent", this.B);
            bundle.putBoolean("vibrate", this.A);
        }
    }

    @Override // com.borax12.materialdaterangepicker.time.RadialPickerLayout.OnValueSelectedListener
    public void f(int i3, int i4, boolean z2) {
        String str = jlWo.RbHEv;
        if (i3 == 0) {
            V(i4, false);
            String str2 = String.format("%d", Integer.valueOf(i4));
            if (this.f66007s && z2) {
                U(1, true, true, false);
                return;
            }
            if (this.P.getCurrentTab() == 0) {
                this.f66002n.setContentDescription(this.L + str + i4);
                Utils.e(this.f66002n, str2);
                return;
            }
            this.V.setContentDescription(this.L + str + i4);
            Utils.e(this.V, str2);
            return;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                Z(i4);
                return;
            } else {
                if (i3 == 3) {
                    if (!R()) {
                        this.H.clear();
                    }
                    M(true);
                    return;
                }
                return;
            }
        }
        W(i4);
        if (this.P.getCurrentTab() == 0) {
            this.f66002n.setContentDescription(this.N + str + i4);
            return;
        }
        this.V.setContentDescription(this.N + str + i4);
    }
}
