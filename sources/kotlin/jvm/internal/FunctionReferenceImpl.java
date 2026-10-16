package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i3, Class cls, String str, String str2, int i4) {
        super(i3, CallableReference.NO_RECEIVER, cls, str, str2, i4);
    }

    public FunctionReferenceImpl(int i3, Object obj, Class cls, String str, String str2, int i4) {
        super(i3, obj, cls, str, str2, i4);
    }
}
