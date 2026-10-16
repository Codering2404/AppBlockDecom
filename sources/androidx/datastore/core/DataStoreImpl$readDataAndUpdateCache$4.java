package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4", f = "DataStoreImpl.kt", l = {306, 309}, m = "invokeSuspend")
final class DataStoreImpl$readDataAndUpdateCache$4<T> extends SuspendLambda implements Function2<Boolean, Continuation<? super Pair<? extends State<T>, ? extends Boolean>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f35633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f35634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ boolean f35635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ DataStoreImpl f35636d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f35637f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DataStoreImpl$readDataAndUpdateCache$4(DataStoreImpl dataStoreImpl, int i3, Continuation continuation) {
        super(2, continuation);
        this.f35636d = dataStoreImpl;
        this.f35637f = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DataStoreImpl$readDataAndUpdateCache$4 dataStoreImpl$readDataAndUpdateCache$4 = new DataStoreImpl$readDataAndUpdateCache$4(this.f35636d, this.f35637f, continuation);
        dataStoreImpl$readDataAndUpdateCache$4.f35635c = ((Boolean) obj).booleanValue();
        return dataStoreImpl$readDataAndUpdateCache$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Throwable th;
        int iIntValue;
        ?? r02;
        ?? r03;
        State state;
        ?? r12;
        Object objF = IntrinsicsKt.f();
        ?? r13 = this.f35634b;
        try {
        } catch (Throwable th2) {
            if (r13 != 0) {
                InterProcessCoordinator interProcessCoordinatorR = this.f35636d.r();
                this.f35633a = th2;
                this.f35635c = r13;
                this.f35634b = 2;
                Object objA = interProcessCoordinatorR.a(this);
                if (objA != objF) {
                    r03 = r13;
                    th = th2;
                    obj = objA;
                }
                return objF;
            }
            ?? r4 = r13;
            th = th2;
            iIntValue = this.f35637f;
            r02 = r4 == true ? 1 : 0;
        }
        if (r13 == 0) {
            ResultKt.b(obj);
            boolean z2 = this.f35635c;
            DataStoreImpl dataStoreImpl = this.f35636d;
            this.f35635c = z2;
            this.f35634b = 1;
            obj = dataStoreImpl.y(z2, this);
            r13 = z2;
            if (obj == objF) {
                return objF;
            }
        } else {
            if (r13 != 1) {
                if (r13 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z3 = this.f35635c;
                th = (Throwable) this.f35633a;
                ResultKt.b(obj);
                r03 = z3;
                iIntValue = ((Number) obj).intValue();
                r02 = r03;
                ReadException readException = new ReadException(th, iIntValue);
                r12 = r02;
                state = readException;
                return TuplesKt.a(state, Boxing.a(r12));
            }
            boolean z4 = this.f35635c;
            ResultKt.b(obj);
            r13 = z4;
        }
        state = (State) obj;
        r12 = r13;
        return TuplesKt.a(state, Boxing.a(r12));
    }

    public final Object invoke(boolean z2, Continuation continuation) {
        return ((DataStoreImpl$readDataAndUpdateCache$4) create(Boolean.valueOf(z2), continuation)).invokeSuspend(Unit.f139807a);
    }
}
