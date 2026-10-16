package kotlinx.serialization.json.internal;

import kotlin.DeepRecursiveScope;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.serialization.json.JsonElement;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
@DebugMetadata(c = "kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", f = "JsonTreeReader.kt", l = {115}, m = "invokeSuspend")
final class JsonTreeReader$readDeepRecursive$1 extends RestrictedSuspendLambda implements Function3<DeepRecursiveScope<Unit, JsonElement>, Unit, Continuation<? super JsonElement>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f143130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f143131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ JsonTreeReader f143132c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JsonTreeReader$readDeepRecursive$1(JsonTreeReader jsonTreeReader, Continuation continuation) {
        super(3, continuation);
        this.f143132c = jsonTreeReader;
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(DeepRecursiveScope deepRecursiveScope, Unit unit, Continuation continuation) {
        JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$1 = new JsonTreeReader$readDeepRecursive$1(this.f143132c, continuation);
        jsonTreeReader$readDeepRecursive$1.f143131b = deepRecursiveScope;
        return jsonTreeReader$readDeepRecursive$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f143130a;
        if (i3 == 0) {
            ResultKt.b(obj);
            DeepRecursiveScope deepRecursiveScope = (DeepRecursiveScope) this.f143131b;
            byte bH = this.f143132c.f143126a.H();
            if (bH == 1) {
                return this.f143132c.j(true);
            }
            if (bH == 0) {
                return this.f143132c.j(false);
            }
            if (bH != 6) {
                if (bH == 8) {
                    return this.f143132c.f();
                }
                AbstractJsonLexer.x(this.f143132c.f143126a, "Can't begin reading element, unexpected token", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            JsonTreeReader jsonTreeReader = this.f143132c;
            this.f143130a = 1;
            obj = jsonTreeReader.h(deepRecursiveScope, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return (JsonElement) obj;
    }
}
