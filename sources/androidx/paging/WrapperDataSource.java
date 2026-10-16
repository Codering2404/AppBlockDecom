package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import java.util.IdentityHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

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
public class WrapperDataSource<Key, ValueFrom, ValueTo> extends DataSource<Key, ValueTo> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DataSource f50721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function f50722g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final IdentityHashMap f50723h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f50724a;

        static {
            int[] iArr = new int[DataSource.KeyType.values().length];
            try {
                iArr[DataSource.KeyType.ITEM_KEYED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f50724a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WrapperDataSource(DataSource source, Function listFunction) {
        super(source.c());
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(listFunction, "listFunction");
        this.f50721f = source;
        this.f50722g = listFunction;
        this.f50723h = WhenMappings.f50724a[source.c().ordinal()] == 1 ? new IdentityHashMap() : null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object i(androidx.paging.WrapperDataSource r4, androidx.paging.DataSource.Params r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof androidx.paging.WrapperDataSource$load$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.paging.WrapperDataSource$load$1 r0 = (androidx.paging.WrapperDataSource$load$1) r0
            int r1 = r0.f50728d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50728d = r1
            goto L18
        L13:
            androidx.paging.WrapperDataSource$load$1 r0 = new androidx.paging.WrapperDataSource$load$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f50726b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f50728d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f50725a
            androidx.paging.WrapperDataSource r4 = (androidx.paging.WrapperDataSource) r4
            kotlin.ResultKt.b(r6)
            goto L45
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.b(r6)
            androidx.paging.DataSource r6 = r4.f50721f
            r0.f50725a = r4
            r0.f50728d = r3
            java.lang.Object r6 = r6.f(r5, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            androidx.paging.DataSource$BaseResult r6 = (androidx.paging.DataSource.BaseResult) r6
            androidx.paging.DataSource$BaseResult$Companion r5 = androidx.paging.DataSource.BaseResult.f49691f
            androidx.arch.core.util.Function r0 = r4.f50722g
            androidx.paging.DataSource$BaseResult r5 = r5.a(r6, r0)
            java.util.List r6 = r6.f49692a
            java.util.List r0 = r5.f49692a
            r4.j(r6, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.WrapperDataSource.i(androidx.paging.WrapperDataSource, androidx.paging.DataSource$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.paging.DataSource
    public void a(DataSource.InvalidatedCallback onInvalidatedCallback) {
        Intrinsics.checkNotNullParameter(onInvalidatedCallback, "onInvalidatedCallback");
        this.f50721f.a(onInvalidatedCallback);
    }

    @Override // androidx.paging.DataSource
    public Object b(Object item) {
        Object obj;
        Intrinsics.checkNotNullParameter(item, "item");
        IdentityHashMap identityHashMap = this.f50723h;
        if (identityHashMap == null) {
            throw new IllegalStateException("Cannot get key by item in non-item keyed DataSource");
        }
        synchronized (identityHashMap) {
            obj = this.f50723h.get(item);
            Intrinsics.checkNotNull(obj);
        }
        return obj;
    }

    @Override // androidx.paging.DataSource
    public void d() {
        this.f50721f.d();
    }

    @Override // androidx.paging.DataSource
    public boolean e() {
        return this.f50721f.e();
    }

    @Override // androidx.paging.DataSource
    public Object f(DataSource.Params params, Continuation continuation) {
        return i(this, params, continuation);
    }

    @Override // androidx.paging.DataSource
    public void h(DataSource.InvalidatedCallback onInvalidatedCallback) {
        Intrinsics.checkNotNullParameter(onInvalidatedCallback, "onInvalidatedCallback");
        this.f50721f.h(onInvalidatedCallback);
    }

    public final void j(List source, List dest) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        IdentityHashMap identityHashMap = this.f50723h;
        if (identityHashMap != null) {
            synchronized (identityHashMap) {
                try {
                    int size = dest.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        IdentityHashMap identityHashMap2 = this.f50723h;
                        Object obj = dest.get(i3);
                        DataSource dataSource = this.f50721f;
                        Intrinsics.checkNotNull(dataSource, "null cannot be cast to non-null type androidx.paging.ItemKeyedDataSource<Key of androidx.paging.WrapperDataSource.stashKeysIfNeeded$lambda$1, ValueFrom of androidx.paging.WrapperDataSource.stashKeysIfNeeded$lambda$1>");
                        identityHashMap2.put(obj, ((ItemKeyedDataSource) dataSource).k(source.get(i3)));
                    }
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
