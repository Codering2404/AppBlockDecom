package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ToInt16PcmAudioProcessor extends BaseAudioProcessor {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    @Override // androidx.media3.common.audio.AudioProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(java.nio.ByteBuffer r12) {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.audio.ToInt16PcmAudioProcessor.d(java.nio.ByteBuffer):void");
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public AudioProcessor.AudioFormat h(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int i3 = audioFormat.f41289c;
        if (i3 == 3 || i3 == 2 || i3 == 268435456 || i3 == 21 || i3 == 1342177280 || i3 == 22 || i3 == 1610612736 || i3 == 4) {
            return i3 != 2 ? new AudioProcessor.AudioFormat(audioFormat.f41287a, audioFormat.f41288b, 2) : AudioProcessor.AudioFormat.f41286e;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }
}
