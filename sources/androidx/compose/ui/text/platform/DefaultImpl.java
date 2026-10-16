package androidx.compose.ui.text.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.emoji2.text.EmojiCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
final class DefaultImpl implements EmojiCompatStatusDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private State f29514a;

    public DefaultImpl() {
        this.f29514a = EmojiCompat.k() ? c() : null;
    }

    private final State c() {
        EmojiCompat emojiCompatC = EmojiCompat.c();
        if (emojiCompatC.g() == 1) {
            return new ImmutableBool(true);
        }
        final MutableState mutableStateE = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
        emojiCompatC.v(new EmojiCompat.InitCallback() { // from class: androidx.compose.ui.text.platform.DefaultImpl$getFontLoadState$initCallback$1
            @Override // androidx.emoji2.text.EmojiCompat.InitCallback
            public void a(Throwable th) {
                this.f29514a = EmojiCompatStatus_androidKt.f29521a;
            }

            @Override // androidx.emoji2.text.EmojiCompat.InitCallback
            public void b() {
                mutableStateE.setValue(Boolean.TRUE);
                this.f29514a = new ImmutableBool(true);
            }
        });
        return mutableStateE;
    }

    @Override // androidx.compose.ui.text.platform.EmojiCompatStatusDelegate
    public State a() {
        State state = this.f29514a;
        if (state != null) {
            Intrinsics.checkNotNull(state);
            return state;
        }
        if (!EmojiCompat.k()) {
            return EmojiCompatStatus_androidKt.f29521a;
        }
        State stateC = c();
        this.f29514a = stateC;
        Intrinsics.checkNotNull(stateC);
        return stateC;
    }
}
