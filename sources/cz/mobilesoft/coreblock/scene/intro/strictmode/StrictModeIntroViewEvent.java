package cz.mobilesoft.coreblock.scene.intro.strictmode;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import java.util.List;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class StrictModeIntroViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAccessMethodConfirmed extends StrictModeIntroViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StrictModeAccessMethod f105030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f105031b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnAccessMethodConfirmed(StrictModeAccessMethod accessMethod, List configurations) {
            super(null);
            Intrinsics.checkNotNullParameter(accessMethod, "accessMethod");
            Intrinsics.checkNotNullParameter(configurations, "configurations");
            this.f105030a = accessMethod;
            this.f105031b = configurations;
        }

        public final StrictModeAccessMethod a() {
            return this.f105030a;
        }

        public final List b() {
            return this.f105031b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnAccessMethodConfirmed)) {
                return false;
            }
            OnAccessMethodConfirmed onAccessMethodConfirmed = (OnAccessMethodConfirmed) obj;
            return this.f105030a == onAccessMethodConfirmed.f105030a && Intrinsics.areEqual(this.f105031b, onAccessMethodConfirmed.f105031b);
        }

        public int hashCode() {
            return (this.f105030a.hashCode() * 31) + this.f105031b.hashCode();
        }

        public String toString() {
            return "OnAccessMethodConfirmed(accessMethod=" + this.f105030a + ", configurations=" + this.f105031b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCloseClicked extends StrictModeIntroViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnCloseClicked f105032a = new OnCloseClicked();

        private OnCloseClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnIntroFinished extends StrictModeIntroViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnIntroFinished f105033a = new OnIntroFinished();

        private OnIntroFinished() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RestartIntro extends StrictModeIntroViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RestartIntro f105034a = new RestartIntro();

        private RestartIntro() {
            super(null);
        }
    }

    public /* synthetic */ StrictModeIntroViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private StrictModeIntroViewEvent() {
    }
}
