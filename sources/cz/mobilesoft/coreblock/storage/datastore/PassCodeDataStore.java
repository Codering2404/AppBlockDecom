package cz.mobilesoft.coreblock.storage.datastore;

import android.content.Context;
import cz.mobilesoft.coreblock.storage.datastore.migration.PassCodePreferencesMigrationKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PassCodeDataStore extends BaseDataStore {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f124434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f124435d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f124436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f124437g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PassCodeDataStore(Context context) {
        super(context, "PIN_LOCK", CollectionsKt.listOf(PassCodePreferencesMigrationKt.a(context)), false, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f124434c = m(DataStoreKeysKt.X1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.h8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PassCodeDataStore.F();
            }
        });
        this.f124435d = m(DataStoreKeysKt.a2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.i8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(PassCodeDataStore.C());
            }
        });
        this.f124436f = m(DataStoreKeysKt.Z1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.j8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(PassCodeDataStore.E());
            }
        });
        this.f124437g = m(DataStoreKeysKt.Y1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.k8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(PassCodeDataStore.D());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long C() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long D() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int E() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String F() {
        return "";
    }

    public final Flow A() {
        return (Flow) this.f124436f.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object B(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof cz.mobilesoft.coreblock.storage.datastore.PassCodeDataStore$isPassCodeSet$1
            if (r0 == 0) goto L13
            r0 = r5
            cz.mobilesoft.coreblock.storage.datastore.PassCodeDataStore$isPassCodeSet$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.PassCodeDataStore$isPassCodeSet$1) r0
            int r1 = r0.f124440c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124440c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.PassCodeDataStore$isPassCodeSet$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.PassCodeDataStore$isPassCodeSet$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f124438a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124440c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L41
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            kotlinx.coroutines.flow.Flow r5 = r4.y()
            r0.f124440c = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.D(r5, r0)
            if (r5 != r1) goto L41
            return r1
        L41:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = kotlin.text.StringsKt.p0(r5)
            r5 = r5 ^ r3
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.PassCodeDataStore.B(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object G(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.a2(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object H(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.X1(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object I(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.Y1(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object J(int i3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.Z1(), Boxing.d(i3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow x() {
        return (Flow) this.f124435d.getValue();
    }

    public final Flow y() {
        return (Flow) this.f124434c.getValue();
    }

    public final Flow z() {
        return (Flow) this.f124437g.getValue();
    }
}
