package cz.mobilesoft.coreblock.scene.sharing.render;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.sharing.render.SocialShareManager", f = "SocialShareManager.kt", l = {42, 49}, m = "executeShareToSystemShareDialog", v = 1)
final class SocialShareManager$executeShareToSystemShareDialog$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f119560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f119561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f119562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f119563d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f119564f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f119565g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f119566h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f119567i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    /* synthetic */ Object f119568j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ SocialShareManager f119569k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f119570l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SocialShareManager$executeShareToSystemShareDialog$1(SocialShareManager socialShareManager, Continuation continuation) {
        super(continuation);
        this.f119569k = socialShareManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f119568j = obj;
        this.f119570l |= Integer.MIN_VALUE;
        return this.f119569k.f(null, null, null, null, null, this);
    }
}
