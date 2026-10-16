package androidx.compose.foundation.content.internal;

import androidx.compose.foundation.content.ReceiveContentListener;
import androidx.compose.foundation.content.ReceiveContentNode;
import androidx.compose.foundation.content.TransferableContent;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

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
public final class DynamicReceiveContentConfiguration extends ReceiveContentConfiguration {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReceiveContentNode f5210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ReceiveContentListener f5211c = new ReceiveContentListener() { // from class: androidx.compose.foundation.content.internal.DynamicReceiveContentConfiguration$receiveContentListener$1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5212a;

        @Override // androidx.compose.foundation.content.ReceiveContentListener
        public void a() {
            int i3 = this.f5212a + 1;
            this.f5212a = i3;
            if (i3 == 1) {
                this.f5213b.e().s2().a();
            }
            ReceiveContentListener receiveContentListenerD = this.f5213b.d();
            if (receiveContentListenerD != null) {
                receiveContentListenerD.a();
            }
        }

        @Override // androidx.compose.foundation.content.ReceiveContentListener
        public void b() {
            this.f5213b.e().s2().b();
            this.f5212a = 0;
        }

        @Override // androidx.compose.foundation.content.ReceiveContentListener
        public void c() {
            this.f5212a = 0;
            this.f5213b.e().s2().c();
        }

        @Override // androidx.compose.foundation.content.ReceiveContentListener
        public void d() {
            int i3 = this.f5212a;
            int iF = RangesKt.f(i3 - 1, 0);
            this.f5212a = iF;
            if (iF == 0 && i3 > 0) {
                this.f5213b.e().s2().d();
            }
            ReceiveContentListener receiveContentListenerD = this.f5213b.d();
            if (receiveContentListenerD != null) {
                receiveContentListenerD.d();
            }
        }

        @Override // androidx.compose.foundation.content.ReceiveContentListener
        public TransferableContent e(TransferableContent transferableContent) {
            TransferableContent transferableContentE = this.f5213b.e().s2().e(transferableContent);
            if (transferableContentE == null) {
                return null;
            }
            ReceiveContentListener receiveContentListenerD = this.f5213b.d();
            return receiveContentListenerD == null ? transferableContentE : receiveContentListenerD.e(transferableContentE);
        }
    };

    public DynamicReceiveContentConfiguration(ReceiveContentNode receiveContentNode) {
        this.f5210b = receiveContentNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReceiveContentListener d() {
        ReceiveContentConfiguration receiveContentConfigurationB = ReceiveContentConfigurationKt.b(this.f5210b);
        if (receiveContentConfigurationB != null) {
            return receiveContentConfigurationB.a();
        }
        return null;
    }

    @Override // androidx.compose.foundation.content.internal.ReceiveContentConfiguration
    public ReceiveContentListener a() {
        return this.f5211c;
    }

    public final ReceiveContentNode e() {
        return this.f5210b;
    }
}
