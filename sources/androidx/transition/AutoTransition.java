package androidx.transition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        E0();
    }

    private void E0() {
        B0(1);
        r0(new Fade(2)).r0(new ChangeBounds()).r0(new Fade(1));
    }
}
