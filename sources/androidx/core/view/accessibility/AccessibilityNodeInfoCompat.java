package androidx.core.view.accessibility;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public class AccessibilityNodeInfoCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AccessibilityNodeInfo f34565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f34566b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f34567c = -1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat A;
        public static final AccessibilityActionCompat B;
        public static final AccessibilityActionCompat C;
        public static final AccessibilityActionCompat D;
        public static final AccessibilityActionCompat E;
        public static final AccessibilityActionCompat F;
        public static final AccessibilityActionCompat G;
        public static final AccessibilityActionCompat H;
        public static final AccessibilityActionCompat I;
        public static final AccessibilityActionCompat J;
        public static final AccessibilityActionCompat K;
        public static final AccessibilityActionCompat L;
        public static final AccessibilityActionCompat M;
        public static final AccessibilityActionCompat N;
        public static final AccessibilityActionCompat O;
        public static final AccessibilityActionCompat P;
        public static final AccessibilityActionCompat Q;
        public static final AccessibilityActionCompat R;
        public static final AccessibilityActionCompat S;
        public static final AccessibilityActionCompat T;
        public static final AccessibilityActionCompat U;
        public static final AccessibilityActionCompat V;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final AccessibilityActionCompat f34568e = new AccessibilityActionCompat(1, null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final AccessibilityActionCompat f34569f = new AccessibilityActionCompat(2, null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final AccessibilityActionCompat f34570g = new AccessibilityActionCompat(4, null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final AccessibilityActionCompat f34571h = new AccessibilityActionCompat(8, null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final AccessibilityActionCompat f34572i = new AccessibilityActionCompat(16, null);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final AccessibilityActionCompat f34573j = new AccessibilityActionCompat(32, null);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final AccessibilityActionCompat f34574k = new AccessibilityActionCompat(64, null);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final AccessibilityActionCompat f34575l = new AccessibilityActionCompat(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, null);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final AccessibilityActionCompat f34576m = new AccessibilityActionCompat(Function.MAX_NARGS, (CharSequence) null, AccessibilityViewCommand.MoveAtGranularityArguments.class);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final AccessibilityActionCompat f34577n = new AccessibilityActionCompat(512, (CharSequence) null, AccessibilityViewCommand.MoveAtGranularityArguments.class);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final AccessibilityActionCompat f34578o = new AccessibilityActionCompat(1024, (CharSequence) null, AccessibilityViewCommand.MoveHtmlArguments.class);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final AccessibilityActionCompat f34579p = new AccessibilityActionCompat(2048, (CharSequence) null, AccessibilityViewCommand.MoveHtmlArguments.class);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final AccessibilityActionCompat f34580q = new AccessibilityActionCompat(4096, null);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final AccessibilityActionCompat f34581r = new AccessibilityActionCompat(Utility.DEFAULT_STREAM_BUFFER_SIZE, null);

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final AccessibilityActionCompat f34582s = new AccessibilityActionCompat(16384, null);

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final AccessibilityActionCompat f34583t = new AccessibilityActionCompat(32768, null);

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final AccessibilityActionCompat f34584u = new AccessibilityActionCompat(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, null);

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final AccessibilityActionCompat f34585v = new AccessibilityActionCompat(131072, (CharSequence) null, AccessibilityViewCommand.SetSelectionArguments.class);

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final AccessibilityActionCompat f34586w = new AccessibilityActionCompat(262144, null);

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final AccessibilityActionCompat f34587x = new AccessibilityActionCompat(524288, null);

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final AccessibilityActionCompat f34588y = new AccessibilityActionCompat(1048576, null);

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final AccessibilityActionCompat f34589z = new AccessibilityActionCompat(2097152, (CharSequence) null, AccessibilityViewCommand.SetTextArguments.class);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f34590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f34591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class f34592c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final AccessibilityViewCommand f34593d;

        static {
            int i3 = Build.VERSION.SDK_INT;
            A = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            B = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
            C = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            D = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            E = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            F = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            G = new AccessibilityActionCompat(i3 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            H = new AccessibilityActionCompat(i3 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            I = new AccessibilityActionCompat(i3 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            J = new AccessibilityActionCompat(i3 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            K = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            L = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, AccessibilityViewCommand.SetProgressArguments.class);
            M = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
            N = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP, R.id.accessibilityActionShowTooltip, null, null, null);
            O = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP, R.id.accessibilityActionHideTooltip, null, null, null);
            P = new AccessibilityActionCompat(i3 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            Q = new AccessibilityActionCompat(i3 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
            R = new AccessibilityActionCompat(i3 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            S = new AccessibilityActionCompat(i3 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
            T = new AccessibilityActionCompat(i3 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
            U = new AccessibilityActionCompat(i3 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            V = new AccessibilityActionCompat(i3 >= 34 ? Api34Impl.a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
        }

        public AccessibilityActionCompat(int i3, CharSequence charSequence) {
            this(null, i3, charSequence, null, null);
        }

        public AccessibilityActionCompat a(CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            return new AccessibilityActionCompat(null, this.f34591b, charSequence, accessibilityViewCommand, this.f34592c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f34590a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f34590a).getLabel();
        }

        public boolean d(View view, Bundle bundle) {
            AccessibilityViewCommand.CommandArguments commandArguments;
            if (this.f34593d == null) {
                return false;
            }
            Class cls = this.f34592c;
            AccessibilityViewCommand.CommandArguments commandArguments2 = null;
            if (cls != null) {
                try {
                    commandArguments = (AccessibilityViewCommand.CommandArguments) cls.getDeclaredConstructor(null).newInstance(null);
                } catch (Exception e3) {
                    e = e3;
                }
                try {
                    commandArguments.a(bundle);
                    commandArguments2 = commandArguments;
                } catch (Exception e4) {
                    e = e4;
                    commandArguments2 = commandArguments;
                    Class cls2 = this.f34592c;
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e);
                }
            }
            return this.f34593d.a(view, commandArguments2);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof AccessibilityActionCompat)) {
                return false;
            }
            AccessibilityActionCompat accessibilityActionCompat = (AccessibilityActionCompat) obj;
            Object obj2 = this.f34590a;
            return obj2 == null ? accessibilityActionCompat.f34590a == null : obj2.equals(accessibilityActionCompat.f34590a);
        }

        public int hashCode() {
            Object obj = this.f34590a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessibilityActionCompat: ");
            String strH = AccessibilityNodeInfoCompat.h(this.f34591b);
            if (strH.equals("ACTION_UNKNOWN") && c() != null) {
                strH = c().toString();
            }
            sb.append(strH);
            return sb.toString();
        }

        public AccessibilityActionCompat(int i3, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            this(null, i3, charSequence, accessibilityViewCommand, null);
        }

        AccessibilityActionCompat(Object obj) {
            this(obj, 0, null, null, null);
        }

        private AccessibilityActionCompat(int i3, CharSequence charSequence, Class cls) {
            this(null, i3, charSequence, null, cls);
        }

        AccessibilityActionCompat(Object obj, int i3, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand, Class cls) {
            this.f34591b = i3;
            this.f34593d = accessibilityViewCommand;
            if (obj == null) {
                this.f34590a = new AccessibilityNodeInfo.AccessibilityAction(i3, charSequence);
            } else {
                this.f34590a = obj;
            }
            this.f34592c = cls;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static class Api30Impl {
        public static CharSequence a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static class Api33Impl {
        public static String a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static class Api34Impl {
        public static AccessibilityNodeInfo.AccessibilityAction a() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static class Api35Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class CollectionInfoCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f34594a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {
        }

        CollectionInfoCompat(Object obj) {
            this.f34594a = obj;
        }

        public static CollectionInfoCompat a(int i3, int i4, boolean z2) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i3, i4, z2));
        }

        public static CollectionInfoCompat b(int i3, int i4, boolean z2, int i5) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i3, i4, z2, i5));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class CollectionItemInfoCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f34595a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {
        }

        CollectionItemInfoCompat(Object obj) {
            this.f34595a = obj;
        }

        public static CollectionItemInfoCompat a(int i3, int i4, int i5, int i6, boolean z2, boolean z3) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i3, i4, i5, i6, z2, z3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class RangeInfoCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f34596a;

        RangeInfoCompat(Object obj) {
            this.f34596a = obj;
        }

        public static RangeInfoCompat a(int i3, float f3, float f4, float f5) {
            return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(i3, f3, f4, f5));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class TouchDelegateInfoCompat {
    }

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f34565a = accessibilityNodeInfo;
    }

    private boolean C() {
        return !f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public static AccessibilityNodeInfoCompat V() {
        return Z0(AccessibilityNodeInfo.obtain());
    }

    public static AccessibilityNodeInfoCompat W(View view) {
        return Z0(AccessibilityNodeInfo.obtain(view));
    }

    public static AccessibilityNodeInfoCompat X(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return Z0(AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.f34565a));
    }

    public static AccessibilityNodeInfoCompat Z0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
    }

    private List f(String str) {
        ArrayList<Integer> integerArrayList = this.f34565a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f34565a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    static String h(int i3) {
        if (i3 == 1) {
            return "ACTION_FOCUS";
        }
        if (i3 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i3) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD /* 128 */:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case Function.MAX_NARGS /* 256 */:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case Utility.DEFAULT_STREAM_BUFFER_SIZE /* 8192 */:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST /* 65536 */:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case R.id.accessibilityActionScrollInDirection:
                return tDEtWsFLJfe.FwKTSWKymAsIR;
            default:
                switch (i3) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i3) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i3) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    private boolean j(int i3) {
        Bundle bundleT = t();
        return bundleT != null && (bundleT.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i3) == i3;
    }

    public static ClickableSpan[] p(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public String A() {
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.a(this.f34565a) : this.f34565a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public void A0(int i3) {
        this.f34565a.setMaxTextLength(i3);
    }

    public String B() {
        return this.f34565a.getViewIdResourceName();
    }

    public void B0(int i3) {
        this.f34565a.setMovementGranularities(i3);
    }

    public void C0(CharSequence charSequence) {
        this.f34565a.setPackageName(charSequence);
    }

    public boolean D() {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.d(this.f34565a) : j(64);
    }

    public void D0(CharSequence charSequence) {
        this.f34565a.setPaneTitle(charSequence);
    }

    public boolean E() {
        return this.f34565a.isAccessibilityFocused();
    }

    public void E0(View view) {
        this.f34566b = -1;
        this.f34565a.setParent(view);
    }

    public boolean F() {
        return this.f34565a.isCheckable();
    }

    public void F0(View view, int i3) {
        this.f34566b = i3;
        this.f34565a.setParent(view, i3);
    }

    public boolean G() {
        return this.f34565a.isChecked();
    }

    public void G0(boolean z2) {
        this.f34565a.setPassword(z2);
    }

    public boolean H() {
        return this.f34565a.isClickable();
    }

    public void H0(RangeInfoCompat rangeInfoCompat) {
        this.f34565a.setRangeInfo((AccessibilityNodeInfo.RangeInfo) rangeInfoCompat.f34596a);
    }

    public boolean I() {
        return this.f34565a.isContextClickable();
    }

    public void I0(CharSequence charSequence) {
        this.f34565a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
    }

    public boolean J() {
        return this.f34565a.isEnabled();
    }

    public void J0(boolean z2) {
        this.f34565a.setScreenReaderFocusable(z2);
    }

    public boolean K() {
        return this.f34565a.isFocusable();
    }

    public void K0(boolean z2) {
        this.f34565a.setScrollable(z2);
    }

    public boolean L() {
        return this.f34565a.isFocused();
    }

    public void L0(boolean z2) {
        this.f34565a.setSelected(z2);
    }

    public boolean M() {
        return j(67108864);
    }

    public void M0(boolean z2) {
        this.f34565a.setShowingHintText(z2);
    }

    public boolean N() {
        return this.f34565a.isImportantForAccessibility();
    }

    public void N0(View view) {
        this.f34567c = -1;
        this.f34565a.setSource(view);
    }

    public boolean O() {
        return this.f34565a.isLongClickable();
    }

    public void O0(View view, int i3) {
        this.f34567c = i3;
        this.f34565a.setSource(view, i3);
    }

    public boolean P() {
        return this.f34565a.isPassword();
    }

    public void P0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.b(this.f34565a, charSequence);
        } else {
            this.f34565a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public boolean Q() {
        return this.f34565a.isScrollable();
    }

    public void Q0(CharSequence charSequence) {
        this.f34565a.setText(charSequence);
    }

    public boolean R() {
        return this.f34565a.isSelected();
    }

    public void R0(int i3, int i4) {
        this.f34565a.setTextSelection(i3, i4);
    }

    public boolean S() {
        return this.f34565a.isShowingHintText();
    }

    public void S0(View view) {
        this.f34565a.setTraversalAfter(view);
    }

    public boolean T() {
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.b(this.f34565a) : j(8388608);
    }

    public void T0(View view, int i3) {
        this.f34565a.setTraversalAfter(view, i3);
    }

    public boolean U() {
        return this.f34565a.isVisibleToUser();
    }

    public void U0(View view) {
        this.f34565a.setTraversalBefore(view);
    }

    public void V0(View view, int i3) {
        this.f34565a.setTraversalBefore(view, i3);
    }

    public void W0(String str) {
        this.f34565a.setViewIdResourceName(str);
    }

    public void X0(boolean z2) {
        this.f34565a.setVisibleToUser(z2);
    }

    public boolean Y(int i3, Bundle bundle) {
        return this.f34565a.performAction(i3, bundle);
    }

    public AccessibilityNodeInfo Y0() {
        return this.f34565a;
    }

    public void Z() {
    }

    public void a(int i3) {
        this.f34565a.addAction(i3);
    }

    public boolean a0(AccessibilityActionCompat accessibilityActionCompat) {
        return this.f34565a.removeAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.f34590a);
    }

    public void b(AccessibilityActionCompat accessibilityActionCompat) {
        this.f34565a.addAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.f34590a);
    }

    public void b0(boolean z2) {
        this.f34565a.setAccessibilityFocused(z2);
    }

    public void c(View view) {
        this.f34565a.addChild(view);
    }

    public void c0(List list) {
        this.f34565a.setAvailableExtraData(list);
    }

    public void d(View view, int i3) {
        this.f34565a.addChild(view, i3);
    }

    public void d0(Rect rect) {
        this.f34565a.setBoundsInParent(rect);
    }

    public void e(CharSequence charSequence, View view) {
    }

    public void e0(Rect rect) {
        this.f34565a.setBoundsInScreen(rect);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityNodeInfoCompat)) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f34565a;
        if (accessibilityNodeInfo == null) {
            if (accessibilityNodeInfoCompat.f34565a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(accessibilityNodeInfoCompat.f34565a)) {
            return false;
        }
        return this.f34567c == accessibilityNodeInfoCompat.f34567c && this.f34566b == accessibilityNodeInfoCompat.f34566b;
    }

    public void f0(boolean z2) {
        this.f34565a.setCanOpenPopup(z2);
    }

    public List g() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f34565a.getActionList();
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(new AccessibilityActionCompat(actionList.get(i3)));
        }
        return arrayList;
    }

    public void g0(boolean z2) {
        this.f34565a.setCheckable(z2);
    }

    public void h0(boolean z2) {
        this.f34565a.setChecked(z2);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f34565a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public int i() {
        return this.f34565a.getActions();
    }

    public void i0(CharSequence charSequence) {
        this.f34565a.setClassName(charSequence);
    }

    public void j0(boolean z2) {
        this.f34565a.setClickable(z2);
    }

    public void k(Rect rect) {
        this.f34565a.getBoundsInParent(rect);
    }

    public void k0(Object obj) {
        this.f34565a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((CollectionInfoCompat) obj).f34594a);
    }

    public void l(Rect rect) {
        this.f34565a.getBoundsInScreen(rect);
    }

    public void l0(Object obj) {
        this.f34565a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((CollectionItemInfoCompat) obj).f34595a);
    }

    public void m(Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.b(this.f34565a, rect);
            return;
        }
        Rect rect2 = (Rect) this.f34565a.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public void m0(CharSequence charSequence) {
        this.f34565a.setContentDescription(charSequence);
    }

    public int n() {
        return this.f34565a.getChildCount();
    }

    public void n0(boolean z2) {
        this.f34565a.setContentInvalid(z2);
    }

    public CharSequence o() {
        return this.f34565a.getClassName();
    }

    public void o0(boolean z2) {
        this.f34565a.setDismissable(z2);
    }

    public void p0(boolean z2) {
        this.f34565a.setEditable(z2);
    }

    public CharSequence q() {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.c(this.f34565a) : this.f34565a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public void q0(boolean z2) {
        this.f34565a.setEnabled(z2);
    }

    public CharSequence r() {
        return this.f34565a.getContentDescription();
    }

    public void r0(CharSequence charSequence) {
        this.f34565a.setError(charSequence);
    }

    public CharSequence s() {
        return this.f34565a.getError();
    }

    public void s0(boolean z2) {
        this.f34565a.setFocusable(z2);
    }

    public Bundle t() {
        return this.f34565a.getExtras();
    }

    public void t0(boolean z2) {
        this.f34565a.setFocused(z2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        k(rect);
        sb.append("; boundsInParent: " + rect);
        l(rect);
        sb.append("; boundsInScreen: " + rect);
        m(rect);
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(w());
        sb.append("; className: ");
        sb.append(o());
        sb.append("; text: ");
        sb.append(y());
        sb.append("; error: ");
        sb.append(s());
        sb.append("; maxTextLength: ");
        sb.append(u());
        sb.append("; stateDescription: ");
        sb.append(x());
        sb.append("; contentDescription: ");
        sb.append(r());
        sb.append("; tooltipText: ");
        sb.append(z());
        sb.append("; viewIdResName: ");
        sb.append(B());
        sb.append("; uniqueId: ");
        sb.append(A());
        sb.append("; checkable: ");
        sb.append(F());
        sb.append("; checked: ");
        sb.append(G());
        sb.append("; focusable: ");
        sb.append(K());
        sb.append("; focused: ");
        sb.append(L());
        sb.append("; selected: ");
        sb.append(R());
        sb.append("; clickable: ");
        sb.append(H());
        sb.append("; longClickable: ");
        sb.append(O());
        sb.append("; contextClickable: ");
        sb.append(I());
        sb.append("; enabled: ");
        sb.append(J());
        sb.append("; password: ");
        sb.append(P());
        sb.append("; scrollable: " + Q());
        sb.append("; containerTitle: ");
        sb.append(q());
        sb.append("; granularScrollingSupported: ");
        sb.append(M());
        sb.append("; importantForAccessibility: ");
        sb.append(N());
        sb.append("; visible: ");
        sb.append(U());
        sb.append("; isTextSelectable: ");
        sb.append(T());
        sb.append("; accessibilityDataSensitive: ");
        sb.append(D());
        sb.append("; [");
        List listG = g();
        for (int i3 = 0; i3 < listG.size(); i3++) {
            AccessibilityActionCompat accessibilityActionCompat = (AccessibilityActionCompat) listG.get(i3);
            String strH = h(accessibilityActionCompat.b());
            if (strH.equals("ACTION_UNKNOWN") && accessibilityActionCompat.c() != null) {
                strH = accessibilityActionCompat.c().toString();
            }
            sb.append(strH);
            if (i3 != listG.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int u() {
        return this.f34565a.getMaxTextLength();
    }

    public void u0(boolean z2) {
        this.f34565a.setHeading(z2);
    }

    public int v() {
        return this.f34565a.getMovementGranularities();
    }

    public void v0(CharSequence charSequence) {
        this.f34565a.setHintText(charSequence);
    }

    public CharSequence w() {
        return this.f34565a.getPackageName();
    }

    public void w0(boolean z2) {
        this.f34565a.setImportantForAccessibility(z2);
    }

    public CharSequence x() {
        return Build.VERSION.SDK_INT >= 30 ? Api30Impl.a(this.f34565a) : this.f34565a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public void x0(View view) {
        this.f34565a.setLabelFor(view);
    }

    public CharSequence y() {
        if (!C()) {
            return this.f34565a.getText();
        }
        List listF = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List listF2 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List listF3 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List listF4 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f34565a.getText(), 0, this.f34565a.getText().length()));
        for (int i3 = 0; i3 < listF.size(); i3++) {
            spannableString.setSpan(new AccessibilityClickableSpanCompat(((Integer) listF4.get(i3)).intValue(), this, t().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) listF.get(i3)).intValue(), ((Integer) listF2.get(i3)).intValue(), ((Integer) listF3.get(i3)).intValue());
        }
        return spannableString;
    }

    public void y0(int i3) {
        this.f34565a.setLiveRegion(i3);
    }

    public CharSequence z() {
        return this.f34565a.getTooltipText();
    }

    public void z0(boolean z2) {
        this.f34565a.setLongClickable(z2);
    }
}
