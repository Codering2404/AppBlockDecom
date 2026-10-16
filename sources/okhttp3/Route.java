package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class Route {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Address f144263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Proxy f144264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InetSocketAddress f144265c;

    public Route(Address address, Proxy proxy, InetSocketAddress socketAddress) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(socketAddress, "socketAddress");
        this.f144263a = address;
        this.f144264b = proxy;
        this.f144265c = socketAddress;
    }

    public final Address a() {
        return this.f144263a;
    }

    public final Proxy b() {
        return this.f144264b;
    }

    public final boolean c() {
        return this.f144263a.k() != null && this.f144264b.type() == Proxy.Type.HTTP;
    }

    public final InetSocketAddress d() {
        return this.f144265c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Route)) {
            return false;
        }
        Route route = (Route) obj;
        return Intrinsics.areEqual(route.f144263a, this.f144263a) && Intrinsics.areEqual(route.f144264b, this.f144264b) && Intrinsics.areEqual(route.f144265c, this.f144265c);
    }

    public int hashCode() {
        return ((((527 + this.f144263a.hashCode()) * 31) + this.f144264b.hashCode()) * 31) + this.f144265c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f144265c + '}';
    }
}
