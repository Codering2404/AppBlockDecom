package androidx.privacysandbox.ads.adservices.topics;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import androidx.privacysandbox.ads.adservices.internal.BackCompatManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class TopicsManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f51368a = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TopicsManager a(final Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            AdServicesInfo adServicesInfo = AdServicesInfo.f51231a;
            if (adServicesInfo.a() >= 11) {
                return new TopicsManagerApi33Ext11Impl(context);
            }
            if (adServicesInfo.a() >= 5) {
                return new TopicsManagerApi33Ext5Impl(context);
            }
            if (adServicesInfo.a() == 4) {
                return new TopicsManagerApi33Ext4Impl(context);
            }
            if (adServicesInfo.b() >= 11) {
                return (TopicsManager) BackCompatManager.f51234a.a(context, "TopicsManager", new Function1<Context, TopicsManagerApi31Ext11Impl>() { // from class: androidx.privacysandbox.ads.adservices.topics.TopicsManager$Companion$obtain$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final TopicsManagerApi31Ext11Impl invoke(Context it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TopicsManagerApi31Ext11Impl(context);
                    }
                });
            }
            if (adServicesInfo.b() >= 9) {
                return (TopicsManager) BackCompatManager.f51234a.a(context, "TopicsManager", new Function1<Context, TopicsManagerApi31Ext9Impl>() { // from class: androidx.privacysandbox.ads.adservices.topics.TopicsManager$Companion$obtain$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final TopicsManagerApi31Ext9Impl invoke(Context it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TopicsManagerApi31Ext9Impl(context);
                    }
                });
            }
            return null;
        }

        private Companion() {
        }
    }

    public abstract Object a(GetTopicsRequest getTopicsRequest, Continuation continuation);
}
