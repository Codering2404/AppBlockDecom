package cz.mobilesoft.coreblock.scene.more.settings.icon_select;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.enums.AppIcon;
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
public abstract class AppIconSelectViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnIconSelected extends AppIconSelectViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AppIcon f109901a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnIconSelected(AppIcon icon) {
            super(null);
            Intrinsics.checkNotNullParameter(icon, "icon");
            this.f109901a = icon;
        }

        public final AppIcon a() {
            return this.f109901a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnIconSelected) && this.f109901a == ((OnIconSelected) obj).f109901a;
        }

        public int hashCode() {
            return this.f109901a.hashCode();
        }

        public String toString() {
            return "OnIconSelected(icon=" + this.f109901a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnRestartConfirmed extends AppIconSelectViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnRestartConfirmed f109902a = new OnRestartConfirmed();

        private OnRestartConfirmed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnRestartConfirmed);
        }

        public int hashCode() {
            return 434103443;
        }

        public String toString() {
            return "OnRestartConfirmed";
        }
    }

    public /* synthetic */ AppIconSelectViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AppIconSelectViewEvent() {
    }
}
