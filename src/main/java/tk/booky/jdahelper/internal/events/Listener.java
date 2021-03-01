package tk.booky.jdahelper.internal.events;
// Created by booky10 in JDABotHelper (19:48 27.09.20)

import net.dv8tion.jda.api.events.*;
import net.dv8tion.jda.api.events.channel.category.CategoryCreateEvent;
import net.dv8tion.jda.api.events.channel.category.CategoryDeleteEvent;
import net.dv8tion.jda.api.events.channel.category.GenericCategoryEvent;
import net.dv8tion.jda.api.events.channel.category.update.CategoryUpdateNameEvent;
import net.dv8tion.jda.api.events.channel.category.update.CategoryUpdatePositionEvent;
import net.dv8tion.jda.api.events.channel.category.update.GenericCategoryUpdateEvent;
import net.dv8tion.jda.api.events.channel.priv.PrivateChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.priv.PrivateChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.store.GenericStoreChannelEvent;
import net.dv8tion.jda.api.events.channel.store.StoreChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.store.StoreChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.store.update.GenericStoreChannelUpdateEvent;
import net.dv8tion.jda.api.events.channel.store.update.StoreChannelUpdateNameEvent;
import net.dv8tion.jda.api.events.channel.store.update.StoreChannelUpdatePositionEvent;
import net.dv8tion.jda.api.events.channel.text.GenericTextChannelEvent;
import net.dv8tion.jda.api.events.channel.text.TextChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.text.TextChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.text.update.*;
import net.dv8tion.jda.api.events.channel.voice.GenericVoiceChannelEvent;
import net.dv8tion.jda.api.events.channel.voice.VoiceChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.voice.VoiceChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.voice.update.*;
import net.dv8tion.jda.api.events.emote.EmoteAddedEvent;
import net.dv8tion.jda.api.events.emote.EmoteRemovedEvent;
import net.dv8tion.jda.api.events.emote.GenericEmoteEvent;
import net.dv8tion.jda.api.events.emote.update.EmoteUpdateNameEvent;
import net.dv8tion.jda.api.events.emote.update.EmoteUpdateRolesEvent;
import net.dv8tion.jda.api.events.emote.update.GenericEmoteUpdateEvent;
import net.dv8tion.jda.api.events.guild.*;
import net.dv8tion.jda.api.events.guild.invite.GenericGuildInviteEvent;
import net.dv8tion.jda.api.events.guild.invite.GuildInviteCreateEvent;
import net.dv8tion.jda.api.events.guild.invite.GuildInviteDeleteEvent;
import net.dv8tion.jda.api.events.guild.member.*;
import net.dv8tion.jda.api.events.guild.member.update.GenericGuildMemberUpdateEvent;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateBoostTimeEvent;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;
import net.dv8tion.jda.api.events.guild.override.GenericPermissionOverrideEvent;
import net.dv8tion.jda.api.events.guild.override.PermissionOverrideCreateEvent;
import net.dv8tion.jda.api.events.guild.override.PermissionOverrideDeleteEvent;
import net.dv8tion.jda.api.events.guild.override.PermissionOverrideUpdateEvent;
import net.dv8tion.jda.api.events.guild.update.*;
import net.dv8tion.jda.api.events.guild.voice.*;
import net.dv8tion.jda.api.events.http.HttpRequestEvent;
import net.dv8tion.jda.api.events.message.*;
import net.dv8tion.jda.api.events.message.guild.*;
import net.dv8tion.jda.api.events.message.guild.react.*;
import net.dv8tion.jda.api.events.message.priv.*;
import net.dv8tion.jda.api.events.message.priv.react.GenericPrivateMessageReactionEvent;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.message.react.*;
import net.dv8tion.jda.api.events.role.GenericRoleEvent;
import net.dv8tion.jda.api.events.role.RoleCreateEvent;
import net.dv8tion.jda.api.events.role.RoleDeleteEvent;
import net.dv8tion.jda.api.events.role.update.*;
import net.dv8tion.jda.api.events.self.*;
import net.dv8tion.jda.api.events.user.GenericUserEvent;
import net.dv8tion.jda.api.events.user.UserActivityEndEvent;
import net.dv8tion.jda.api.events.user.UserActivityStartEvent;
import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.events.user.update.*;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import tk.booky.jdahelper.api.activities.Activity;
import tk.booky.jdahelper.api.event.Event;
import tk.booky.jdahelper.api.event.events.category.*;
import tk.booky.jdahelper.api.event.events.connection.*;
import tk.booky.jdahelper.api.event.events.direct.*;
import tk.booky.jdahelper.api.event.events.emote.*;
import tk.booky.jdahelper.api.event.events.gateway.GatewayEvent;
import tk.booky.jdahelper.api.event.events.gateway.GatewayPingedEvent;
import tk.booky.jdahelper.api.event.events.guild.GuildEvent;
import tk.booky.jdahelper.api.event.events.message.*;
import tk.booky.jdahelper.api.event.events.other.ErrorEvent;
import tk.booky.jdahelper.api.event.events.other.HTTPRequestEvent;
import tk.booky.jdahelper.api.event.events.other.StatusEvent;
import tk.booky.jdahelper.api.event.events.other.UpdatedEvent;
import tk.booky.jdahelper.api.event.events.permission.PermissionOverrideCreatedEvent;
import tk.booky.jdahelper.api.event.events.permission.PermissionOverrideDeletedEvent;
import tk.booky.jdahelper.api.event.events.permission.PermissionOverrideEvent;
import tk.booky.jdahelper.api.event.events.permission.PermissionOverrideUpdatedEvent;
import tk.booky.jdahelper.api.event.events.role.*;
import tk.booky.jdahelper.api.event.events.self.*;
import tk.booky.jdahelper.api.event.events.store.*;
import tk.booky.jdahelper.api.event.events.text.*;
import tk.booky.jdahelper.api.event.events.user.*;
import tk.booky.jdahelper.api.event.events.voice.*;
import tk.booky.jdahelper.api.status.Status;

public final class Listener extends ListenerAdapter {

    @Override
    public void onGenericEvent(@NotNull GenericEvent event) {
        new Event(event.getJDA(), event.getResponseNumber()).call();
    }

    @Override
    public void onGenericUpdate(@NotNull UpdateEvent<?, ?> event) {
        new UpdatedEvent<>(event.getJDA(), event.getResponseNumber(), event.getPropertyIdentifier(), event.getEntity(), event.getOldValue(), event.getNewValue()).call();
    }

    @Override
    public void onRawGateway(@NotNull RawGatewayEvent event) {
        new GatewayEvent(event.getJDA(), event.getResponseNumber(), event.getPackage()).call();
    }

    @Override
    public void onGatewayPing(@NotNull GatewayPingEvent event) {
        new GatewayPingedEvent(event.getJDA(), event.getOldPing()).call();
    }

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        new ConnectionStartedEvent(event.getJDA(), event.getResponseNumber()).call();
    }

    @Override
    public void onResume(@NotNull ResumedEvent event) {
        new ConnectionResumedEvent(event.getJDA(), event.getResponseNumber()).call();
    }

    @Override
    public void onReconnect(@NotNull ReconnectedEvent event) {
        new ConnectionReconnectedEvent(event.getJDA(), event.getResponseNumber()).call();
    }

    @Override
    public void onDisconnect(@NotNull DisconnectEvent event) {
        new ConnectionDisconnectedEvent(event.getJDA(), event.getServiceCloseFrame(), event.getClientCloseFrame(), event.isClosedByServer(), event.getTimeDisconnected()).call();
    }

    @Override
    public void onShutdown(@NotNull ShutdownEvent event) {
        new ConnectionShutdownEvent(event.getJDA(), event.getTimeShutdown(), event.getCode()).call();
    }

    @Override
    public void onStatusChange(@NotNull StatusChangeEvent event) {
        new StatusEvent(event.getEntity(), event.getOldStatus()).call();
    }

    @Override
    public void onException(@NotNull ExceptionEvent event) {
        new ErrorEvent(event.getJDA(), event.getCause(), event.isLogged()).call();
    }

    @Override
    public void onUserUpdateName(@NotNull UserUpdateNameEvent event) {
        new UserUpdatedNameEvent(event.getJDA(), event.getResponseNumber(), event.getUser(), event.getOldName()).call();
    }

    @Override
    public void onUserUpdateDiscriminator(@NotNull UserUpdateDiscriminatorEvent event) {
        new UserUpdatedTagEvent(event.getJDA(), event.getResponseNumber(), event.getUser(), event.getOldDiscriminator()).call();
    }

    @Override
    public void onUserUpdateAvatar(@NotNull UserUpdateAvatarEvent event) {
        new UserUpdatedAvatarEvent(event.getJDA(), event.getResponseNumber(), event.getUser(), event.getOldAvatarId()).call();
    }

    @Override
    public void onUserUpdateOnlineStatus(@NotNull UserUpdateOnlineStatusEvent event) {
        new UserActivityStatusChangedEvent(event.getJDA(), event.getResponseNumber(), event.getMember(), Status.fromJDA(event.getOldOnlineStatus())).call();
    }

    @Override
    public void onUserUpdateActivityOrder(@NotNull UserUpdateActivityOrderEvent event) {
        new UserActivityUpdatedOrderEvent(event.getJDA(), event.getResponseNumber(), Activity.fromJDA(event.getOldValue()), event.getMember()).call();
    }

    @Override
    public void onUserUpdateFlags(@NotNull UserUpdateFlagsEvent event) {
        new UserUpdatedFlagsEvent(event.getJDA(), event.getResponseNumber(), event.getUser(), event.getOldFlags()).call();
    }

    @Override
    public void onUserTyping(@NotNull UserTypingEvent event) {
        new UserCaughtTypingEvent(event.getJDA(), event.getResponseNumber(), event.getUser(), event.getChannel(), event.getTimestamp()).call();
    }

    @Override
    public void onUserActivityStart(@NotNull UserActivityStartEvent event) {
        new UserActivityStartedEvent(event.getJDA(), event.getResponseNumber(), event.getMember(), Activity.fromJDA(event.getNewActivity())).call();
    }

    @Override
    public void onUserActivityEnd(@NotNull UserActivityEndEvent event) {
        new UserActivityEndedEvent(event.getJDA(), event.getResponseNumber(), event.getMember(), Activity.fromJDA(event.getOldActivity())).call();
    }

    @Override
    public void onSelfUpdateAvatar(@NotNull SelfUpdateAvatarEvent event) {
        new SelfUpdatedAvatarEvent(event.getJDA(), event.getResponseNumber(), event.getOldAvatarId()).call();
    }

    @Override
    public void onSelfUpdateMFA(@NotNull SelfUpdateMFAEvent event) {
        new SelfUpdatedMFAEvent(event.getJDA(), event.getResponseNumber(), event.wasMfaEnabled()).call();
    }

    @Override
    public void onSelfUpdateName(@NotNull SelfUpdateNameEvent event) {
        new SelfUpdatedNameEvent(event.getJDA(), event.getResponseNumber(), event.getOldName()).call();
    }

    @Override
    public void onSelfUpdateVerified(@NotNull SelfUpdateVerifiedEvent event) {
        new SelfUpdatedVerifiedEvent(event.getJDA(), event.getResponseNumber(), event.wasVerified()).call();
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);
    }

    @Override
    public void onGuildMessageUpdate(@NotNull GuildMessageUpdateEvent event) {
        //TODO: IMPLEMENT THIS
        super.onGuildMessageUpdate(event);
    }

    @Override
    public void onGuildMessageDelete(@NotNull GuildMessageDeleteEvent event) {
        super.onGuildMessageDelete(event);
    }

    @Override
    public void onGuildMessageEmbed(@NotNull GuildMessageEmbedEvent event) {
        super.onGuildMessageEmbed(event);
    }

    @Override
    public void onGuildMessageReactionAdd(@NotNull GuildMessageReactionAddEvent event) {
        super.onGuildMessageReactionAdd(event);
    }

    @Override
    public void onGuildMessageReactionRemove(@NotNull GuildMessageReactionRemoveEvent event) {
        super.onGuildMessageReactionRemove(event);
    }

    @Override
    public void onGuildMessageReactionRemoveAll(@NotNull GuildMessageReactionRemoveAllEvent event) {
        super.onGuildMessageReactionRemoveAll(event);
    }

    @Override
    public void onGuildMessageReactionRemoveEmote(@NotNull GuildMessageReactionRemoveEmoteEvent event) {
        super.onGuildMessageReactionRemoveEmote(event);
    }

    @Override
    public void onPrivateMessageReceived(@NotNull PrivateMessageReceivedEvent event) {
        new DirectMessageReceiveEvent(event.getJDA(), event.getResponseNumber(), event.getMessageIdLong(), event.getChannel(), event.getMessage()).call();
    }

    @Override
    public void onPrivateMessageUpdate(@NotNull PrivateMessageUpdateEvent event) {
        new DirectMessageUpdatedEvent(event.getJDA(), event.getResponseNumber(), event.getMessageIdLong(), event.getChannel(), event.getMessage()).call();
    }

    @Override
    public void onPrivateMessageDelete(@NotNull PrivateMessageDeleteEvent event) {
        new DirectMessageDeletedEvent(event.getJDA(), event.getResponseNumber(), event.getMessageIdLong(), event.getChannel()).call();
    }

    @Override
    public void onPrivateMessageEmbed(@NotNull PrivateMessageEmbedEvent event) {
        new DirectEmbedReceiveEvent(event.getJDA(), event.getResponseNumber(), event.getMessageIdLong(), event.getChannel(), event.getMessageEmbeds()).call();
    }

    @Override
    public void onPrivateMessageReactionAdd(@NotNull PrivateMessageReactionAddEvent event) {
        new DirectReactionAddEvent(event.getJDA(), event.getResponseNumber(), event.getUserIdLong(), event.getReaction()).call();
    }

    @Override
    public void onPrivateMessageReactionRemove(@NotNull PrivateMessageReactionRemoveEvent event) {
        new DirectReactionRemoveEvent(event.getJDA(), event.getResponseNumber(), event.getUserIdLong(), event.getReaction()).call();
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        new MessageReceiveEvent(event.getJDA(), event.getResponseNumber(), event.getMessage()).call();
    }

    @Override
    public void onMessageUpdate(@NotNull MessageUpdateEvent event) {
        new MessageUpdatedEvent(event.getJDA(), event.getResponseNumber(), event.getMessage()).call();
    }

    @Override
    public void onMessageDelete(@NotNull MessageDeleteEvent event) {
        new MessageDeletedEvent(event.getJDA(), event.getResponseNumber(), event.getMessageIdLong(), event.getChannel()).call();
    }

    @Override
    public void onMessageBulkDelete(@NotNull MessageBulkDeleteEvent event) {
        new MessagesPurgedEvent(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getMessageIds()).call();
    }

    @Override
    public void onMessageEmbed(@NotNull MessageEmbedEvent event) {
        new EmbedReceiveEvent(event.getJDA(), event.getResponseNumber(), event.getMessageIdLong(), event.getChannel(), event.getMessageEmbeds()).call();
    }

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        new ReactionAddEvent(event.getJDA(), event.getResponseNumber(), event.getMember(), event.getReaction()).call();
    }

    @Override
    public void onMessageReactionRemove(@NotNull MessageReactionRemoveEvent event) {
        new ReactionRemoveEvent(event.getJDA(), event.getResponseNumber(), event.getMember(), event.getReaction()).call();
    }

    @Override
    public void onMessageReactionRemoveAll(@NotNull MessageReactionRemoveAllEvent event) {
        new ReactionRemoveAllEvent(event.getJDA(), event.getResponseNumber(), event.getMessageIdLong(), event.getChannel()).call();
    }

    @Override
    public void onMessageReactionRemoveEmote(@NotNull MessageReactionRemoveEmoteEvent event) {
        new ReactionRemoveEmoteEvent(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getReaction()).call();
    }

    @Override
    public void onPermissionOverrideDelete(@NotNull PermissionOverrideDeleteEvent event) {
        new PermissionOverrideDeletedEvent(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getPermissionOverride()).call();
    }

    @Override
    public void onPermissionOverrideUpdate(@NotNull PermissionOverrideUpdateEvent event) {
        new PermissionOverrideUpdatedEvent(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getPermissionOverride(), event.getOldAllowRaw(), event.getOldDenyRaw()).call();
    }

    @Override
    public void onPermissionOverrideCreate(@NotNull PermissionOverrideCreateEvent event) {
        new PermissionOverrideCreatedEvent(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getPermissionOverride()).call();
    }

    @Override
    public void onStoreChannelDelete(@NotNull StoreChannelDeleteEvent event) {
        new StoreChannelDeletedEvent(event.getJDA(), event.getResponseNumber(), event.getChannel()).call();
    }

    @Override
    public void onStoreChannelUpdateName(@NotNull StoreChannelUpdateNameEvent event) {
        new StoreChannelUpdatedNameEvent(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getOldName()).call();
    }

    @Override
    public void onStoreChannelUpdatePosition(@NotNull StoreChannelUpdatePositionEvent event) {
        new StoreChannelUpdatedPositionEvent(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getOldPosition()).call();
    }

    @Override
    public void onStoreChannelCreate(@NotNull StoreChannelCreateEvent event) {
        new StoreChannelCreatedEvent(event.getJDA(), event.getResponseNumber(), event.getChannel()).call();
    }

    @Override
    public void onTextChannelDelete(@NotNull TextChannelDeleteEvent event) {
        new TextChannelDeletedEvent(event.getJDA(), event.getResponseNumber(), event.getChannel()).call();
    }

    @Override
    public void onTextChannelUpdateName(@NotNull TextChannelUpdateNameEvent event) {
        new TextChannelUpdatedNameEvent(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getOldName()).call();
    }

    @Override
    public void onTextChannelUpdateTopic(@NotNull TextChannelUpdateTopicEvent event) {
        new TextChannelUpdatedTopicEvent(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getOldTopic()).call();
    }

    @Override
    public void onTextChannelUpdatePosition(@NotNull TextChannelUpdatePositionEvent event) {
        new TextChannelUpdatedPositionEvent(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getOldPosition()).call();
    }

    @Override
    public void onTextChannelUpdateNSFW(@NotNull TextChannelUpdateNSFWEvent event) {
        new TextChannelUpdatedNSFWEvent(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getOldNSFW()).call();
    }

    @Override
    public void onTextChannelUpdateParent(@NotNull TextChannelUpdateParentEvent event) {
        new TextChannelUpdatedParentEvent(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getOldParent()).call();
    }

    @Override
    public void onTextChannelUpdateSlowmode(@NotNull TextChannelUpdateSlowmodeEvent event) {
        new TextChannelUpdatedSlowModeEvent(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getOldSlowmode()).call();
    }

    @Override
    public void onTextChannelUpdateNews(@NotNull TextChannelUpdateNewsEvent event) {
        new TextChannelUpdatedNewsEvent(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getOldValue()).call();
    }

    @Override
    public void onTextChannelCreate(@NotNull TextChannelCreateEvent event) {
        new TextChannelCreatedEvent(event.getJDA(), event.getResponseNumber(), event.getChannel()).call();
    }

    @Override
    public void onVoiceChannelDelete(@NotNull VoiceChannelDeleteEvent event) {
        new VoiceChannelDeletedEvent(event.getJDA(), event.getResponseNumber(), event.getChannel()).call();
    }

    @Override
    public void onVoiceChannelUpdateName(@NotNull VoiceChannelUpdateNameEvent event) {
        new VoiceChannelUpdatedNameEvent(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getOldName()).call();
    }

    @Override
    public void onVoiceChannelUpdatePosition(@NotNull VoiceChannelUpdatePositionEvent event) {
        new VoiceChannelUpdatedPositionEvent(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getOldPosition()).call();
    }

    @Override
    public void onVoiceChannelUpdateUserLimit(@NotNull VoiceChannelUpdateUserLimitEvent event) {
        new VoiceChannelUpdatedUserLimitEvent(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getOldUserLimit()).call();
    }

    @Override
    public void onVoiceChannelUpdateBitrate(@NotNull VoiceChannelUpdateBitrateEvent event) {
        new VoiceChannelUpdatedBitrateEvent(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getOldBitrate()).call();
    }

    @Override
    public void onVoiceChannelUpdateParent(@NotNull VoiceChannelUpdateParentEvent event) {
        new VoiceChannelUpdatedParentEvent(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getOldParent()).call();
    }

    @Override
    public void onVoiceChannelCreate(@NotNull VoiceChannelCreateEvent event) {
        new VoiceChannelCreatedEvent(event.getJDA(), event.getResponseNumber(), event.getChannel()).call();
    }

    @Override
    public void onCategoryDelete(@NotNull CategoryDeleteEvent event) {
        new CategoryDeletedEvent(event.getJDA(), event.getResponseNumber(), event.getCategory()).call();
    }

    @Override
    public void onCategoryUpdateName(@NotNull CategoryUpdateNameEvent event) {
        new CategoryUpdatedNameEvent(event.getJDA(), event.getResponseNumber(), event.getCategory(), event.getOldName()).call();
    }

    @Override
    public void onCategoryUpdatePosition(@NotNull CategoryUpdatePositionEvent event) {
        new CategoryUpdatedPositionEvent(event.getJDA(), event.getResponseNumber(), event.getCategory(), event.getOldPosition()).call();
    }

    @Override
    public void onCategoryCreate(@NotNull CategoryCreateEvent event) {
        new CategoryCreatedEvent(event.getJDA(), event.getResponseNumber(), event.getCategory()).call();
    }

    @Override
    public void onPrivateChannelCreate(@NotNull PrivateChannelCreateEvent event) {
        new DirectChannelCreatedEvent(event.getJDA(), event.getChannel()).call();
    }

    @Override
    public void onPrivateChannelDelete(@NotNull PrivateChannelDeleteEvent event) {
        new DirectChannelDeletedEvent(event.getJDA(), event.getResponseNumber(), event.getChannel()).call();
    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        super.onGuildReady(event);
    }

    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        super.onGuildJoin(event);
    }

    @Override
    public void onGuildLeave(@NotNull GuildLeaveEvent event) {
        super.onGuildLeave(event);
    }

    @Override
    public void onGuildAvailable(@NotNull GuildAvailableEvent event) {
        super.onGuildAvailable(event);
    }

    @Override
    public void onGuildUnavailable(@NotNull GuildUnavailableEvent event) {
        super.onGuildUnavailable(event);
    }

    @Override
    public void onUnavailableGuildJoined(@NotNull UnavailableGuildJoinedEvent event) {
        super.onUnavailableGuildJoined(event);
    }

    @Override
    public void onUnavailableGuildLeave(@NotNull UnavailableGuildLeaveEvent event) {
        super.onUnavailableGuildLeave(event);
    }

    @Override
    public void onGuildBan(@NotNull GuildBanEvent event) {
        super.onGuildBan(event);
    }

    @Override
    public void onGuildUnban(@NotNull GuildUnbanEvent event) {
        super.onGuildUnban(event);
    }

    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {
        super.onGuildMemberRemove(event);
    }

    @Override
    public void onGuildUpdateAfkChannel(@NotNull GuildUpdateAfkChannelEvent event) {
        super.onGuildUpdateAfkChannel(event);
    }

    @Override
    public void onGuildUpdateSystemChannel(@NotNull GuildUpdateSystemChannelEvent event) {
        super.onGuildUpdateSystemChannel(event);
    }

    @Override
    public void onGuildUpdateAfkTimeout(@NotNull GuildUpdateAfkTimeoutEvent event) {
        super.onGuildUpdateAfkTimeout(event);
    }

    @Override
    public void onGuildUpdateExplicitContentLevel(@NotNull GuildUpdateExplicitContentLevelEvent event) {
        super.onGuildUpdateExplicitContentLevel(event);
    }

    @Override
    public void onGuildUpdateIcon(@NotNull GuildUpdateIconEvent event) {
        super.onGuildUpdateIcon(event);
    }

    @Override
    public void onGuildUpdateMFALevel(@NotNull GuildUpdateMFALevelEvent event) {
        super.onGuildUpdateMFALevel(event);
    }

    @Override
    public void onGuildUpdateName(@NotNull GuildUpdateNameEvent event) {
        super.onGuildUpdateName(event);
    }

    @Override
    public void onGuildUpdateNotificationLevel(@NotNull GuildUpdateNotificationLevelEvent event) {
        super.onGuildUpdateNotificationLevel(event);
    }

    @Override
    public void onGuildUpdateOwner(@NotNull GuildUpdateOwnerEvent event) {
        super.onGuildUpdateOwner(event);
    }

    @Override
    public void onGuildUpdateRegion(@NotNull GuildUpdateRegionEvent event) {
        super.onGuildUpdateRegion(event);
    }

    @Override
    public void onGuildUpdateSplash(@NotNull GuildUpdateSplashEvent event) {
        super.onGuildUpdateSplash(event);
    }

    @Override
    public void onGuildUpdateVerificationLevel(@NotNull GuildUpdateVerificationLevelEvent event) {
        super.onGuildUpdateVerificationLevel(event);
    }

    @Override
    public void onGuildUpdateLocale(@NotNull GuildUpdateLocaleEvent event) {
        super.onGuildUpdateLocale(event);
    }

    @Override
    public void onGuildUpdateFeatures(@NotNull GuildUpdateFeaturesEvent event) {
        super.onGuildUpdateFeatures(event);
    }

    @Override
    public void onGuildUpdateVanityCode(@NotNull GuildUpdateVanityCodeEvent event) {
        super.onGuildUpdateVanityCode(event);
    }

    @Override
    public void onGuildUpdateBanner(@NotNull GuildUpdateBannerEvent event) {
        super.onGuildUpdateBanner(event);
    }

    @Override
    public void onGuildUpdateDescription(@NotNull GuildUpdateDescriptionEvent event) {
        super.onGuildUpdateDescription(event);
    }

    @Override
    public void onGuildUpdateBoostTier(@NotNull GuildUpdateBoostTierEvent event) {
        super.onGuildUpdateBoostTier(event);
    }

    @Override
    public void onGuildUpdateBoostCount(@NotNull GuildUpdateBoostCountEvent event) {
        super.onGuildUpdateBoostCount(event);
    }

    @Override
    public void onGuildUpdateMaxMembers(@NotNull GuildUpdateMaxMembersEvent event) {
        super.onGuildUpdateMaxMembers(event);
    }

    @Override
    public void onGuildUpdateMaxPresences(@NotNull GuildUpdateMaxPresencesEvent event) {
        super.onGuildUpdateMaxPresences(event);
    }

    @Override
    public void onGuildInviteCreate(@NotNull GuildInviteCreateEvent event) {
        super.onGuildInviteCreate(event);
    }

    @Override
    public void onGuildInviteDelete(@NotNull GuildInviteDeleteEvent event) {
        super.onGuildInviteDelete(event);
    }

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        super.onGuildMemberJoin(event);
    }

    @Override
    public void onGuildMemberRoleAdd(@NotNull GuildMemberRoleAddEvent event) {
        super.onGuildMemberRoleAdd(event);
    }

    @Override
    public void onGuildMemberRoleRemove(@NotNull GuildMemberRoleRemoveEvent event) {
        super.onGuildMemberRoleRemove(event);
    }

    @Override
    public void onGuildMemberUpdateNickname(@NotNull GuildMemberUpdateNicknameEvent event) {
        super.onGuildMemberUpdateNickname(event);
    }

    @Override
    public void onGuildMemberUpdateBoostTime(@NotNull GuildMemberUpdateBoostTimeEvent event) {
        super.onGuildMemberUpdateBoostTime(event);
    }

    @Override
    public void onGuildVoiceUpdate(@NotNull GuildVoiceUpdateEvent event) {
        super.onGuildVoiceUpdate(event);
    }

    @Override
    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event) {
        super.onGuildVoiceJoin(event);
    }

    @Override
    public void onGuildVoiceMove(@NotNull GuildVoiceMoveEvent event) {
        super.onGuildVoiceMove(event);
    }

    @Override
    public void onGuildVoiceLeave(@NotNull GuildVoiceLeaveEvent event) {
        super.onGuildVoiceLeave(event);
    }

    @Override
    public void onGuildVoiceMute(@NotNull GuildVoiceMuteEvent event) {
        super.onGuildVoiceMute(event);
    }

    @Override
    public void onGuildVoiceDeafen(@NotNull GuildVoiceDeafenEvent event) {
        super.onGuildVoiceDeafen(event);
    }

    @Override
    public void onGuildVoiceGuildMute(@NotNull GuildVoiceGuildMuteEvent event) {
        super.onGuildVoiceGuildMute(event);
    }

    @Override
    public void onGuildVoiceGuildDeafen(@NotNull GuildVoiceGuildDeafenEvent event) {
        super.onGuildVoiceGuildDeafen(event);
    }

    @Override
    public void onGuildVoiceSelfMute(@NotNull GuildVoiceSelfMuteEvent event) {
        super.onGuildVoiceSelfMute(event);
    }

    @Override
    public void onGuildVoiceSelfDeafen(@NotNull GuildVoiceSelfDeafenEvent event) {
        super.onGuildVoiceSelfDeafen(event);
    }

    @Override
    public void onGuildVoiceSuppress(@NotNull GuildVoiceSuppressEvent event) {
        super.onGuildVoiceSuppress(event);
    }

    @Override
    public void onGuildVoiceStream(@NotNull GuildVoiceStreamEvent event) {
        super.onGuildVoiceStream(event);
    }

    @Override
    public void onRoleCreate(@NotNull RoleCreateEvent event) {
        new RoleCreatedEvent(event.getJDA(), event.getResponseNumber(), event.getRole()).call();
    }

    @Override
    public void onRoleDelete(@NotNull RoleDeleteEvent event) {
        new RoleDeletedEvent(event.getJDA(), event.getResponseNumber(), event.getRole()).call();
    }

    @Override
    public void onRoleUpdateColor(@NotNull RoleUpdateColorEvent event) {
        new RoleUpdatedColorEvent(event.getJDA(), event.getResponseNumber(), event.getRole(), event.getOldColorRaw()).call();
    }

    @Override
    public void onRoleUpdateHoisted(@NotNull RoleUpdateHoistedEvent event) {
        new RoleUpdatedHoistedEvent(event.getJDA(), event.getResponseNumber(), event.getRole(), event.wasHoisted()).call();
    }

    @Override
    public void onRoleUpdateMentionable(@NotNull RoleUpdateMentionableEvent event) {
        new RoleUpdatedMentionable(event.getJDA(), event.getResponseNumber(), event.getRole(), event.wasMentionable()).call();
    }

    @Override
    public void onRoleUpdateName(@NotNull RoleUpdateNameEvent event) {
        new RoleUpdatedNameEvent(event.getJDA(), event.getResponseNumber(), event.getRole(), event.getOldName()).call();
    }

    @Override
    public void onRoleUpdatePermissions(@NotNull RoleUpdatePermissionsEvent event) {
        new RoleUpdatedPermissionsEvent(event.getJDA(), event.getResponseNumber(), event.getRole(), event.getOldPermissionsRaw()).call();
    }

    @Override
    public void onRoleUpdatePosition(@NotNull RoleUpdatePositionEvent event) {
        new RoleUpdatedPositionEvent(event.getJDA(), event.getResponseNumber(), event.getRole(), event.getOldPositionRaw()).call();
    }

    @Override
    public void onEmoteAdded(@NotNull EmoteAddedEvent event) {
        new EmoteAddEvent(event.getJDA(), event.getResponseNumber(), event.getEmote()).call();
    }

    @Override
    public void onEmoteRemoved(@NotNull EmoteRemovedEvent event) {
        new EmoteRemoveEvent(event.getJDA(), event.getResponseNumber(), event.getEmote()).call();
    }

    @Override
    public void onEmoteUpdateName(@NotNull EmoteUpdateNameEvent event) {
        new EmoteUpdatedNameEvent(event.getJDA(), event.getResponseNumber(), event.getEmote(), event.getOldName()).call();
    }

    @Override
    public void onEmoteUpdateRoles(@NotNull EmoteUpdateRolesEvent event) {
        new EmoteUpdatedRolesEvent(event.getJDA(), event.getResponseNumber(), event.getEmote(), event.getOldRoles()).call();
    }

    @Override
    public void onHttpRequest(@NotNull HttpRequestEvent event) {
        new HTTPRequestEvent(event.getRequest(), event.getResponse()).call();
    }

    @Override
    public void onGenericMessage(@NotNull GenericMessageEvent event) {
        new MessageEvent(event.getJDA(), event.getResponseNumber(), event.getMessageIdLong(), event.getChannel()).call();
    }

    @Override
    public void onGenericMessageReaction(@NotNull GenericMessageReactionEvent event) {
        new ReactionEvent(event.getJDA(), event.getResponseNumber(), event.getUser(), event.getMember(), event.getReaction(), event.getUserIdLong()).call();
    }

    @Override
    public void onGenericGuildMessage(@NotNull GenericGuildMessageEvent event) {
        super.onGenericGuildMessage(event);
    }

    @Override
    public void onGenericGuildMessageReaction(@NotNull GenericGuildMessageReactionEvent event) {
        super.onGenericGuildMessageReaction(event);
    }

    @Override
    public void onGenericPrivateMessage(@NotNull GenericPrivateMessageEvent event) {
        new DirectMessageEvent(event.getJDA(), event.getResponseNumber(), event.getMessageIdLong(), event.getChannel()).call();
    }

    @Override
    public void onGenericPrivateMessageReaction(@NotNull GenericPrivateMessageReactionEvent event) {
        new DirectReactionEvent(event.getJDA(), event.getResponseNumber(), event.getUserIdLong(), event.getReaction()).call();
    }

    @Override
    public void onGenericUser(@NotNull GenericUserEvent event) {
        new UserEvent(event.getJDA(), event.getResponseNumber(), event.getUser()).call();
    }

    @Override
    public void onGenericUserPresence(@NotNull GenericUserPresenceEvent event) {
        new UserActivityEvent(event.getJDA(), event.getResponseNumber(), event.getGuild(), event.getMember()).call();
    }

    @Override
    public void onGenericSelfUpdate(@NotNull GenericSelfUpdateEvent event) {
        new SelfUpdatedEvent<>(event.getJDA(), event.getResponseNumber(), event.getOldValue(), event.getNewValue(), event.getPropertyIdentifier()).call();
    }

    @Override
    public void onGenericStoreChannel(@NotNull GenericStoreChannelEvent event) {
        new StoreChannelEvent(event.getJDA(), event.getResponseNumber(), event.getChannel()).call();
    }

    @Override
    public void onGenericStoreChannelUpdate(@NotNull GenericStoreChannelUpdateEvent event) {
        new StoreChannelUpdatedEvent<>(event.getJDA(), event.getResponseNumber(), event.getEntity(), event.getOldValue(), event.getNewValue(), event.getPropertyIdentifier()).call();
    }

    @Override
    public void onGenericTextChannel(@NotNull GenericTextChannelEvent event) {
        new TextChannelEvent(event.getJDA(), event.getResponseNumber(), event.getChannel()).call();
    }

    @Override
    public void onGenericTextChannelUpdate(@NotNull GenericTextChannelUpdateEvent event) {
        new TextChannelUpdatedEvent<>(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getOldValue(), event.getNewValue(), event.getPropertyIdentifier()).call();
    }

    @Override
    public void onGenericVoiceChannel(@NotNull GenericVoiceChannelEvent event) {
        new VoiceChannelEvent(event.getJDA(), event.getResponseNumber(), event.getChannel()).call();
    }

    @Override
    public void onGenericVoiceChannelUpdate(@NotNull GenericVoiceChannelUpdateEvent event) {
        new VoiceChannelUpdatedEvent<>(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getOldValue(), event.getNewValue(), event.getPropertyIdentifier()).call();
    }

    @Override
    public void onGenericCategory(@NotNull GenericCategoryEvent event) {
        new CategoryEvent(event.getJDA(), event.getResponseNumber(), event.getCategory()).call();
    }

    @Override
    public void onGenericCategoryUpdate(@NotNull GenericCategoryUpdateEvent event) {
        new CategoryUpdatedEvent<>(event.getJDA(), event.getResponseNumber(), event.getCategory(), event.getOldValue(), event.getNewValue(), event.getPropertyIdentifier()).call();
    }

    @Override
    public void onGenericGuild(@NotNull GenericGuildEvent event) {
        new GuildEvent(event.getJDA(), event.getResponseNumber(), event.getGuild()).call();
    }

    @Override
    public void onGenericGuildUpdate(@NotNull GenericGuildUpdateEvent event) {
        super.onGenericGuildUpdate(event);
    }

    @Override
    public void onGenericGuildInvite(@NotNull GenericGuildInviteEvent event) {
        super.onGenericGuildInvite(event);
    }

    @Override
    public void onGenericGuildMember(@NotNull GenericGuildMemberEvent event) {
        super.onGenericGuildMember(event);
    }

    @Override
    public void onGenericGuildMemberUpdate(@NotNull GenericGuildMemberUpdateEvent event) {
        super.onGenericGuildMemberUpdate(event);
    }

    @Override
    public void onGenericGuildVoice(@NotNull GenericGuildVoiceEvent event) {
        super.onGenericGuildVoice(event);
    }

    @Override
    public void onGenericRole(@NotNull GenericRoleEvent event) {
        new RoleEvent(event.getJDA(), event.getResponseNumber(), event.getRole()).call();
    }

    @Override
    public void onGenericRoleUpdate(@NotNull GenericRoleUpdateEvent event) {
        new RoleUpdatedEvent<>(event.getJDA(), event.getResponseNumber(), event.getRole(), event.getOldValue(), event.getNewValue(), event.getPropertyIdentifier()).call();
    }

    @Override
    public void onGenericEmote(@NotNull GenericEmoteEvent event) {
        new EmoteEvent(event.getJDA(), event.getResponseNumber(), event.getEmote()).call();
    }

    @Override
    public void onGenericEmoteUpdate(@NotNull GenericEmoteUpdateEvent event) {
        new EmoteUpdatedEvent<>(event.getJDA(), event.getResponseNumber(), event.getEmote(), event.getOldValue(), event.getNewValue(), event.getPropertyIdentifier()).call();
    }

    @Override
    public void onGenericPermissionOverride(@NotNull GenericPermissionOverrideEvent event) {
        new PermissionOverrideEvent(event.getJDA(), event.getResponseNumber(), event.getChannel(), event.getPermissionOverride()).call();
    }
}