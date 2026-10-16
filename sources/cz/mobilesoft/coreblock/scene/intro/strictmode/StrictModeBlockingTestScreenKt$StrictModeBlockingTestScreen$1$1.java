package cz.mobilesoft.coreblock.scene.intro.strictmode;

import android.content.Context;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeBlockingTestScreenKt$StrictModeBlockingTestScreen$1$1", f = "StrictModeBlockingTestScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class StrictModeBlockingTestScreenKt$StrictModeBlockingTestScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f104998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MutableState f104999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f105000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f105001d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableIntState f105002f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableState f105003g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f105004a;

        static {
            int[] iArr = new int[TestSteps.values().length];
            try {
                iArr[TestSteps.STEP1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TestSteps.STEP2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TestSteps.STEP3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TestSteps.STEP4.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TestSteps.STEP5.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f105004a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictModeBlockingTestScreenKt$StrictModeBlockingTestScreen$1$1(MutableState mutableState, MutableState mutableState2, Context context, MutableIntState mutableIntState, MutableState mutableState3, Continuation continuation) {
        super(2, continuation);
        this.f104999b = mutableState;
        this.f105000c = mutableState2;
        this.f105001d = context;
        this.f105002f = mutableIntState;
        this.f105003g = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StrictModeBlockingTestScreenKt$StrictModeBlockingTestScreen$1$1(this.f104999b, this.f105000c, this.f105001d, this.f105002f, this.f105003g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f104998a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        int i3 = WhenMappings.f105004a[((TestSteps) this.f104999b.getValue()).ordinal()];
        if (i3 == 1) {
            MutableState mutableState = this.f105000c;
            String string = this.f105001d.getString(R.string.gz);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            mutableState.setValue(string);
            this.f105002f.a(R.drawable.Ta);
            this.f105003g.setValue(Boxing.a(false));
        } else if (i3 == 2) {
            MutableState mutableState2 = this.f105000c;
            String string2 = this.f105001d.getString(R.string.hz);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            mutableState2.setValue(string2);
            this.f105002f.a(R.drawable.Ua);
            this.f105003g.setValue(Boxing.a(false));
        } else if (i3 == 3) {
            MutableState mutableState3 = this.f105000c;
            String string3 = this.f105001d.getString(R.string.iz);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            mutableState3.setValue(string3);
            this.f105002f.a(R.drawable.Ua);
            this.f105003g.setValue(Boxing.a(true));
        } else if (i3 == 4) {
            MutableState mutableState4 = this.f105000c;
            String string4 = this.f105001d.getString(R.string.jz);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            mutableState4.setValue(string4);
            this.f105002f.a(R.drawable.Va);
            this.f105003g.setValue(Boxing.a(false));
        } else {
            if (i3 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            MutableState mutableState5 = this.f105000c;
            String string5 = this.f105001d.getString(R.string.kz);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            mutableState5.setValue(string5);
            this.f105002f.a(R.drawable.Wa);
            this.f105003g.setValue(Boxing.a(false));
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StrictModeBlockingTestScreenKt$StrictModeBlockingTestScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
