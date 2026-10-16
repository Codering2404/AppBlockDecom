package androidx.paging;

import androidx.recyclerview.widget.ListUpdateCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class OverlappingListsDiffDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OverlappingListsDiffDispatcher f49932a = new OverlappingListsDiffDispatcher();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class PlaceholderUsingUpdateCallback<T> implements ListUpdateCallback {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final Companion f49933j = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PlaceholderPaddedList f49934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final PlaceholderPaddedList f49935b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ListUpdateCallback f49936c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f49937d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f49938f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f49939g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f49940h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f49941i;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public PlaceholderUsingUpdateCallback(PlaceholderPaddedList oldList, PlaceholderPaddedList newList, ListUpdateCallback callback) {
            Intrinsics.checkNotNullParameter(oldList, "oldList");
            Intrinsics.checkNotNullParameter(newList, "newList");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.f49934a = oldList;
            this.f49935b = newList;
            this.f49936c = callback;
            this.f49937d = oldList.d();
            this.f49938f = oldList.f();
            this.f49939g = oldList.a();
            this.f49940h = 1;
            this.f49941i = 1;
        }

        private final boolean e(int i3, int i4) {
            if (i3 < this.f49939g || this.f49941i == 2) {
                return false;
            }
            int iMin = Math.min(i4, this.f49938f);
            if (iMin > 0) {
                this.f49941i = 3;
                this.f49936c.c(this.f49937d + i3, iMin, DiffingChangePayload.PLACEHOLDER_TO_ITEM);
                this.f49938f -= iMin;
            }
            int i5 = i4 - iMin;
            if (i5 <= 0) {
                return true;
            }
            this.f49936c.a(i3 + iMin + this.f49937d, i5);
            return true;
        }

        private final boolean f(int i3, int i4) {
            if (i3 > 0 || this.f49940h == 2) {
                return false;
            }
            int iMin = Math.min(i4, this.f49937d);
            if (iMin > 0) {
                this.f49940h = 3;
                this.f49936c.c((0 - iMin) + this.f49937d, iMin, DiffingChangePayload.PLACEHOLDER_TO_ITEM);
                this.f49937d -= iMin;
            }
            int i5 = i4 - iMin;
            if (i5 <= 0) {
                return true;
            }
            this.f49936c.a(this.f49937d, i5);
            return true;
        }

        private final boolean g(int i3, int i4) {
            if (i3 + i4 < this.f49939g || this.f49941i == 3) {
                return false;
            }
            int iF = RangesKt.f(Math.min(this.f49935b.f() - this.f49938f, i4), 0);
            int i5 = i4 - iF;
            if (iF > 0) {
                this.f49941i = 2;
                this.f49936c.c(this.f49937d + i3, iF, DiffingChangePayload.ITEM_TO_PLACEHOLDER);
                this.f49938f += iF;
            }
            if (i5 <= 0) {
                return true;
            }
            this.f49936c.b(i3 + iF + this.f49937d, i5);
            return true;
        }

        private final boolean h(int i3, int i4) {
            if (i3 > 0 || this.f49940h == 3) {
                return false;
            }
            int iF = RangesKt.f(Math.min(this.f49935b.d() - this.f49937d, i4), 0);
            int i5 = i4 - iF;
            if (i5 > 0) {
                this.f49936c.b(this.f49937d, i5);
            }
            if (iF <= 0) {
                return true;
            }
            this.f49940h = 2;
            this.f49936c.c(this.f49937d, iF, DiffingChangePayload.ITEM_TO_PLACEHOLDER);
            this.f49937d += iF;
            return true;
        }

        private final void i() {
            int iMin = Math.min(this.f49934a.d(), this.f49937d);
            int iD = this.f49935b.d() - this.f49937d;
            if (iD > 0) {
                if (iMin > 0) {
                    this.f49936c.c(0, iMin, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
                }
                this.f49936c.a(0, iD);
            } else if (iD < 0) {
                this.f49936c.b(0, -iD);
                int i3 = iMin + iD;
                if (i3 > 0) {
                    this.f49936c.c(0, i3, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
                }
            }
            this.f49937d = this.f49935b.d();
        }

        private final void k() {
            int iMin = Math.min(this.f49934a.f(), this.f49938f);
            int iF = this.f49935b.f();
            int i3 = this.f49938f;
            int i4 = iF - i3;
            int i5 = this.f49937d + this.f49939g + i3;
            int i6 = i5 - iMin;
            boolean z2 = i6 != this.f49934a.getSize() - iMin;
            if (i4 > 0) {
                this.f49936c.a(i5, i4);
            } else if (i4 < 0) {
                this.f49936c.b(i5 + i4, -i4);
                iMin += i4;
            }
            if (iMin > 0 && z2) {
                this.f49936c.c(i6, iMin, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
            }
            this.f49938f = this.f49935b.f();
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void a(int i3, int i4) {
            if (!e(i3, i4) && !f(i3, i4)) {
                this.f49936c.a(i3 + this.f49937d, i4);
            }
            this.f49939g += i4;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void b(int i3, int i4) {
            if (!g(i3, i4) && !h(i3, i4)) {
                this.f49936c.b(i3 + this.f49937d, i4);
            }
            this.f49939g -= i4;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void c(int i3, int i4, Object obj) {
            this.f49936c.c(i3 + this.f49937d, i4, obj);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void d(int i3, int i4) {
            ListUpdateCallback listUpdateCallback = this.f49936c;
            int i5 = this.f49937d;
            listUpdateCallback.d(i3 + i5, i4 + i5);
        }

        public final void j() {
            i();
            k();
        }
    }

    private OverlappingListsDiffDispatcher() {
    }

    public final void a(PlaceholderPaddedList oldList, PlaceholderPaddedList newList, ListUpdateCallback callback, PlaceholderPaddedDiffResult diffResult) {
        Intrinsics.checkNotNullParameter(oldList, "oldList");
        Intrinsics.checkNotNullParameter(newList, "newList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(diffResult, "diffResult");
        PlaceholderUsingUpdateCallback placeholderUsingUpdateCallback = new PlaceholderUsingUpdateCallback(oldList, newList, callback);
        diffResult.a().c(placeholderUsingUpdateCallback);
        placeholderUsingUpdateCallback.j();
    }
}
