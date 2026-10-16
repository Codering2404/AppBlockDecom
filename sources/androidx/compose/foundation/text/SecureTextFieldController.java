package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusState;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.FlowKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SecureTextFieldController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final State f9876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PasswordInputTransformation f9877b = new PasswordInputTransformation(new SecureTextFieldController$passwordInputTransformation$1(this));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CodepointTransformation f9878c = new CodepointTransformation() { // from class: androidx.compose.foundation.text.b
        @Override // androidx.compose.foundation.text.input.internal.CodepointTransformation
        public final int a(int i3, int i4) {
            return SecureTextFieldController.c(this.f10093a, i3, i4);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Modifier f9879d = FocusChangedModifierKt.a(Modifier.b8, new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.SecureTextFieldController$focusChangeModifier$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FocusState) obj);
            return Unit.f139807a;
        }

        public final void invoke(FocusState focusState) {
            if (focusState.a()) {
                return;
            }
            this.f9881a.f().b();
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Channel f9880e = ChannelKt.b(Api.BaseClientBuilder.API_PRIORITY_OTHER, null, null, 6, null);

    public SecureTextFieldController(State state) {
        this.f9876a = state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int c(SecureTextFieldController secureTextFieldController, int i3, int i4) {
        return i3 == secureTextFieldController.f9877b.a() ? i4 : ((Character) secureTextFieldController.f9876a.getValue()).charValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        if (ChannelResult.j(this.f9880e.h(Unit.f139807a))) {
            this.f9877b.b();
        }
    }

    public final CodepointTransformation d() {
        return this.f9878c;
    }

    public final Modifier e() {
        return this.f9879d;
    }

    public final PasswordInputTransformation f() {
        return this.f9877b;
    }

    public final Object g(Continuation continuation) {
        Object objL = FlowKt.l(FlowKt.r(this.f9880e), new SecureTextFieldController$observeHideEvents$2(this, null), continuation);
        return objL == IntrinsicsKt.f() ? objL : Unit.f139807a;
    }
}
