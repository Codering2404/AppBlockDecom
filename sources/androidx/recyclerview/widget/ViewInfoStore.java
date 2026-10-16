package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class ViewInfoStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SimpleArrayMap f52070a = new SimpleArrayMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final LongSparseArray f52071b = new LongSparseArray();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class InfoRecord {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static Pools.Pool f52072d = new Pools.SimplePool(20);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f52073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        RecyclerView.ItemAnimator.ItemHolderInfo f52074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        RecyclerView.ItemAnimator.ItemHolderInfo f52075c;

        private InfoRecord() {
        }

        static void a() {
            while (f52072d.a() != null) {
            }
        }

        static InfoRecord b() {
            InfoRecord infoRecord = (InfoRecord) f52072d.a();
            return infoRecord == null ? new InfoRecord() : infoRecord;
        }

        static void c(InfoRecord infoRecord) {
            infoRecord.f52073a = 0;
            infoRecord.f52074b = null;
            infoRecord.f52075c = null;
            f52072d.b(infoRecord);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface ProcessCallback {
        void a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void b(RecyclerView.ViewHolder viewHolder);

        void c(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void d(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);
    }

    ViewInfoStore() {
    }

    private RecyclerView.ItemAnimator.ItemHolderInfo l(RecyclerView.ViewHolder viewHolder, int i3) {
        InfoRecord infoRecord;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        int iD = this.f52070a.d(viewHolder);
        if (iD >= 0 && (infoRecord = (InfoRecord) this.f52070a.j(iD)) != null) {
            int i4 = infoRecord.f52073a;
            if ((i4 & i3) != 0) {
                int i5 = (~i3) & i4;
                infoRecord.f52073a = i5;
                if (i3 == 4) {
                    itemHolderInfo = infoRecord.f52074b;
                } else {
                    if (i3 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    itemHolderInfo = infoRecord.f52075c;
                }
                if ((i5 & 12) == 0) {
                    this.f52070a.h(iD);
                    InfoRecord.c(infoRecord);
                }
                return itemHolderInfo;
            }
        }
        return null;
    }

    void a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecordB = (InfoRecord) this.f52070a.get(viewHolder);
        if (infoRecordB == null) {
            infoRecordB = InfoRecord.b();
            this.f52070a.put(viewHolder, infoRecordB);
        }
        infoRecordB.f52073a |= 2;
        infoRecordB.f52074b = itemHolderInfo;
    }

    void b(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecordB = (InfoRecord) this.f52070a.get(viewHolder);
        if (infoRecordB == null) {
            infoRecordB = InfoRecord.b();
            this.f52070a.put(viewHolder, infoRecordB);
        }
        infoRecordB.f52073a |= 1;
    }

    void c(long j3, RecyclerView.ViewHolder viewHolder) {
        this.f52071b.m(j3, viewHolder);
    }

    void d(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecordB = (InfoRecord) this.f52070a.get(viewHolder);
        if (infoRecordB == null) {
            infoRecordB = InfoRecord.b();
            this.f52070a.put(viewHolder, infoRecordB);
        }
        infoRecordB.f52075c = itemHolderInfo;
        infoRecordB.f52073a |= 8;
    }

    void e(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecordB = (InfoRecord) this.f52070a.get(viewHolder);
        if (infoRecordB == null) {
            infoRecordB = InfoRecord.b();
            this.f52070a.put(viewHolder, infoRecordB);
        }
        infoRecordB.f52074b = itemHolderInfo;
        infoRecordB.f52073a |= 4;
    }

    void f() {
        this.f52070a.clear();
        this.f52071b.b();
    }

    RecyclerView.ViewHolder g(long j3) {
        return (RecyclerView.ViewHolder) this.f52071b.g(j3);
    }

    boolean h(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = (InfoRecord) this.f52070a.get(viewHolder);
        return (infoRecord == null || (infoRecord.f52073a & 1) == 0) ? false : true;
    }

    boolean i(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = (InfoRecord) this.f52070a.get(viewHolder);
        return (infoRecord == null || (infoRecord.f52073a & 4) == 0) ? false : true;
    }

    void j() {
        InfoRecord.a();
    }

    public void k(RecyclerView.ViewHolder viewHolder) {
        p(viewHolder);
    }

    RecyclerView.ItemAnimator.ItemHolderInfo m(RecyclerView.ViewHolder viewHolder) {
        return l(viewHolder, 8);
    }

    RecyclerView.ItemAnimator.ItemHolderInfo n(RecyclerView.ViewHolder viewHolder) {
        return l(viewHolder, 4);
    }

    void o(ProcessCallback processCallback) {
        for (int size = this.f52070a.size() - 1; size >= 0; size--) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) this.f52070a.f(size);
            InfoRecord infoRecord = (InfoRecord) this.f52070a.h(size);
            int i3 = infoRecord.f52073a;
            if ((i3 & 3) == 3) {
                processCallback.b(viewHolder);
            } else if ((i3 & 1) != 0) {
                RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo = infoRecord.f52074b;
                if (itemHolderInfo == null) {
                    processCallback.b(viewHolder);
                } else {
                    processCallback.c(viewHolder, itemHolderInfo, infoRecord.f52075c);
                }
            } else if ((i3 & 14) == 14) {
                processCallback.a(viewHolder, infoRecord.f52074b, infoRecord.f52075c);
            } else if ((i3 & 12) == 12) {
                processCallback.d(viewHolder, infoRecord.f52074b, infoRecord.f52075c);
            } else if ((i3 & 4) != 0) {
                processCallback.c(viewHolder, infoRecord.f52074b, null);
            } else if ((i3 & 8) != 0) {
                processCallback.a(viewHolder, infoRecord.f52074b, infoRecord.f52075c);
            }
            InfoRecord.c(infoRecord);
        }
    }

    void p(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = (InfoRecord) this.f52070a.get(viewHolder);
        if (infoRecord == null) {
            return;
        }
        infoRecord.f52073a &= -2;
    }

    void q(RecyclerView.ViewHolder viewHolder) {
        int iR = this.f52071b.r() - 1;
        while (true) {
            if (iR < 0) {
                break;
            }
            if (viewHolder == this.f52071b.s(iR)) {
                this.f52071b.q(iR);
                break;
            }
            iR--;
        }
        InfoRecord infoRecord = (InfoRecord) this.f52070a.remove(viewHolder);
        if (infoRecord != null) {
            InfoRecord.c(infoRecord);
        }
    }
}
