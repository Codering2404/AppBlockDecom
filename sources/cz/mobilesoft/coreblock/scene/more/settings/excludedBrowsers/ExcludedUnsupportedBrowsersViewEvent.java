package cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers;

import cz.mobilesoft.coreblock.base.ViewEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class ExcludedUnsupportedBrowsersViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RemoveUnsupportedBrowser extends ExcludedUnsupportedBrowsersViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f109646a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RemoveUnsupportedBrowser(String packageName) {
            super(null);
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            this.f109646a = packageName;
        }

        public final String a() {
            return this.f109646a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RemoveUnsupportedBrowser) && Intrinsics.areEqual(this.f109646a, ((RemoveUnsupportedBrowser) obj).f109646a);
        }

        public int hashCode() {
            return this.f109646a.hashCode();
        }

        public String toString() {
            return "RemoveUnsupportedBrowser(packageName=" + this.f109646a + ")";
        }
    }

    public /* synthetic */ ExcludedUnsupportedBrowsersViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ExcludedUnsupportedBrowsersViewEvent() {
    }
}
