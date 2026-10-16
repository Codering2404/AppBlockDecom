package androidx.media3.exoplayer.upstream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface Allocator {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AllocationNode {
        Allocation a();

        AllocationNode next();
    }

    void a(AllocationNode allocationNode);

    Allocation b();

    void c(Allocation allocation);

    void d();

    int e();
}
