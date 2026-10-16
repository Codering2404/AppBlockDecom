package kotlinx.coroutines.channels;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;

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
public class ConflatedBufferedChannel<E> extends BufferedChannel<E> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f141348n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final BufferOverflow f141349o;

    public /* synthetic */ ConflatedBufferedChannel(int i3, BufferOverflow bufferOverflow, Function1 function1, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, bufferOverflow, (i4 & 4) != 0 ? null : function1);
    }

    static /* synthetic */ Object I1(ConflatedBufferedChannel conflatedBufferedChannel, Object obj, Continuation continuation) throws Throwable {
        UndeliveredElementException undeliveredElementExceptionC;
        Object objL1 = conflatedBufferedChannel.L1(obj, true);
        if (!(objL1 instanceof ChannelResult.Closed)) {
            return Unit.f139807a;
        }
        ChannelResult.e(objL1);
        Function1 function1 = conflatedBufferedChannel.f141077b;
        if (function1 == null || (undeliveredElementExceptionC = OnUndeliveredElementKt.c(function1, obj, null, 2, null)) == null) {
            throw conflatedBufferedChannel.s0();
        }
        ExceptionsKt.a(undeliveredElementExceptionC, conflatedBufferedChannel.s0());
        throw undeliveredElementExceptionC;
    }

    static /* synthetic */ Object J1(ConflatedBufferedChannel conflatedBufferedChannel, Object obj, Continuation continuation) {
        Object objL1 = conflatedBufferedChannel.L1(obj, true);
        if (objL1 instanceof ChannelResult.Failed) {
            return Boxing.a(false);
        }
        return Boxing.a(true);
    }

    private final Object K1(Object obj, boolean z2) {
        Function1 function1;
        UndeliveredElementException undeliveredElementExceptionC;
        Object objH = super.h(obj);
        if (ChannelResult.k(objH) || ChannelResult.i(objH)) {
            return objH;
        }
        if (!z2 || (function1 = this.f141077b) == null || (undeliveredElementExceptionC = OnUndeliveredElementKt.c(function1, obj, null, 2, null)) == null) {
            return ChannelResult.f141130b.c(Unit.f139807a);
        }
        throw undeliveredElementExceptionC;
    }

    private final Object L1(Object obj, boolean z2) {
        return this.f141349o == BufferOverflow.f141064c ? K1(obj, z2) : y1(obj);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected boolean G0() {
        return this.f141349o == BufferOverflow.f141063b;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public Object h(Object obj) {
        return L1(obj, false);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected void l1(SelectInstance selectInstance, Object obj) {
        Object objH = h(obj);
        if (!(objH instanceof ChannelResult.Failed)) {
            selectInstance.d(Unit.f139807a);
        } else {
            if (!(objH instanceof ChannelResult.Closed)) {
                throw new IllegalStateException("unreachable");
            }
            ChannelResult.e(objH);
            selectInstance.d(BufferedChannelKt.z());
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public Object r1(Object obj, Continuation continuation) {
        return J1(this, obj, continuation);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean v1() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public Object y(Object obj, Continuation continuation) {
        return I1(this, obj, continuation);
    }

    public ConflatedBufferedChannel(int i3, BufferOverflow bufferOverflow, Function1 function1) {
        super(i3, function1);
        this.f141348n = i3;
        this.f141349o = bufferOverflow;
        if (bufferOverflow == BufferOverflow.f141062a) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.b(BufferedChannel.class).m() + " instead").toString());
        }
        if (i3 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i3 + " was specified").toString());
    }
}
