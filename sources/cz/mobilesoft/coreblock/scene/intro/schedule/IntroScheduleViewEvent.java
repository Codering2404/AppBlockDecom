package cz.mobilesoft.coreblock.scene.intro.schedule;

import cz.mobilesoft.coreblock.base.ViewEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public abstract class IntroScheduleViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnResume extends IntroScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnResume f104823a = new OnResume();

        private OnResume() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnScheduleCreated extends IntroScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f104824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f104825b;

        public OnScheduleCreated(long j3, int i3) {
            super(null);
            this.f104824a = j3;
            this.f104825b = i3;
        }

        public final long a() {
            return this.f104824a;
        }

        public final int b() {
            return this.f104825b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnScheduleCreated)) {
                return false;
            }
            OnScheduleCreated onScheduleCreated = (OnScheduleCreated) obj;
            return this.f104824a == onScheduleCreated.f104824a && this.f104825b == onScheduleCreated.f104825b;
        }

        public int hashCode() {
            return (Long.hashCode(this.f104824a) * 31) + Integer.hashCode(this.f104825b);
        }

        public String toString() {
            return "OnScheduleCreated(id=" + this.f104824a + ", typeCombinations=" + this.f104825b + ")";
        }
    }

    public /* synthetic */ IntroScheduleViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private IntroScheduleViewEvent() {
    }
}
