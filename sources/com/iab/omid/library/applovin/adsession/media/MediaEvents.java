package com.iab.omid.library.applovin.adsession.media;

import com.facebook.internal.ServerProtocol;
import com.facebook.login.LoginLogger;
import com.iab.omid.library.applovin.adsession.AdSession;
import com.iab.omid.library.applovin.adsession.a;
import com.iab.omid.library.applovin.internal.i;
import com.iab.omid.library.applovin.utils.c;
import com.iab.omid.library.applovin.utils.g;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MediaEvents {
    private final a adSession;

    private MediaEvents(a aVar) {
        this.adSession = aVar;
    }

    private void confirmValidDuration(float f3) {
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
    }

    private void confirmValidVolume(float f3) {
        if (f3 < 0.0f || f3 > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    public static MediaEvents createMediaEvents(AdSession adSession) {
        a aVar = (a) adSession;
        g.a(adSession, "AdSession is null");
        g.f(aVar);
        g.c(aVar);
        g.b(aVar);
        g.h(aVar);
        MediaEvents mediaEvents = new MediaEvents(aVar);
        aVar.getAdSessionStatePublisher().a(mediaEvents);
        return mediaEvents;
    }

    public void adUserInteraction(InteractionType interactionType) {
        g.a(interactionType, "InteractionType is null");
        g.a(this.adSession);
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "interactionType", interactionType);
        this.adSession.getAdSessionStatePublisher().a("adUserInteraction", jSONObject);
    }

    public void bufferFinish() {
        g.a(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("bufferFinish");
    }

    public void bufferStart() {
        g.a(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("bufferStart");
    }

    public void complete() {
        g.a(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("complete");
    }

    public void firstQuartile() {
        g.a(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("firstQuartile");
    }

    public void midpoint() {
        g.a(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("midpoint");
    }

    public void pause() {
        g.a(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("pause");
    }

    public void playerStateChange(PlayerState playerState) {
        g.a(playerState, "PlayerState is null");
        g.a(this.adSession);
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, ServerProtocol.DIALOG_PARAM_STATE, playerState);
        this.adSession.getAdSessionStatePublisher().a("playerStateChange", jSONObject);
    }

    public void resume() {
        g.a(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("resume");
    }

    public void skipped() {
        g.a(this.adSession);
        this.adSession.getAdSessionStatePublisher().a(LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED);
    }

    public void start(float f3, float f4) {
        confirmValidDuration(f3);
        confirmValidVolume(f4);
        g.a(this.adSession);
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "duration", Float.valueOf(f3));
        c.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f4));
        c.a(jSONObject, "deviceVolume", Float.valueOf(i.c().b()));
        this.adSession.getAdSessionStatePublisher().a("start", jSONObject);
    }

    public void thirdQuartile() {
        g.a(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("thirdQuartile");
    }

    public void volumeChange(float f3) {
        confirmValidVolume(f3);
        g.a(this.adSession);
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f3));
        c.a(jSONObject, "deviceVolume", Float.valueOf(i.c().b()));
        this.adSession.getAdSessionStatePublisher().a("volumeChange", jSONObject);
    }
}
