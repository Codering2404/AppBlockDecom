package androidx.recyclerview.widget;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ListUpdateCallback f51521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f51522b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f51523c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f51524d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f51525f = null;

    public BatchingListUpdateCallback(ListUpdateCallback listUpdateCallback) {
        this.f51521a = listUpdateCallback;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void a(int i3, int i4) {
        int i5;
        if (this.f51522b == 1 && i3 >= (i5 = this.f51523c)) {
            int i6 = this.f51524d;
            if (i3 <= i5 + i6) {
                this.f51524d = i6 + i4;
                this.f51523c = Math.min(i3, i5);
                return;
            }
        }
        e();
        this.f51523c = i3;
        this.f51524d = i4;
        this.f51522b = 1;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void b(int i3, int i4) {
        int i5;
        if (this.f51522b == 2 && (i5 = this.f51523c) >= i3 && i5 <= i3 + i4) {
            this.f51524d += i4;
            this.f51523c = i3;
        } else {
            e();
            this.f51523c = i3;
            this.f51524d = i4;
            this.f51522b = 2;
        }
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void c(int i3, int i4, Object obj) {
        int i5;
        if (this.f51522b == 3) {
            int i6 = this.f51523c;
            int i7 = this.f51524d;
            if (i3 <= i6 + i7 && (i5 = i3 + i4) >= i6 && this.f51525f == obj) {
                this.f51523c = Math.min(i3, i6);
                this.f51524d = Math.max(i7 + i6, i5) - this.f51523c;
                return;
            }
        }
        e();
        this.f51523c = i3;
        this.f51524d = i4;
        this.f51525f = obj;
        this.f51522b = 3;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void d(int i3, int i4) {
        e();
        this.f51521a.d(i3, i4);
    }

    public void e() {
        int i3 = this.f51522b;
        if (i3 == 0) {
            return;
        }
        if (i3 == 1) {
            this.f51521a.a(this.f51523c, this.f51524d);
        } else if (i3 == 2) {
            this.f51521a.b(this.f51523c, this.f51524d);
        } else if (i3 == 3) {
            this.f51521a.c(this.f51523c, this.f51524d, this.f51525f);
        }
        this.f51525f = null;
        this.f51522b = 0;
    }
}
