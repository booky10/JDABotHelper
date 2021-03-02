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
import tk.booky.jdahelper.api.utils.Helper;

public final class Listener extends ListenerAdapter {

    @Override
    public void onRawGateway(@NotNull RawGatewayEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGatewayPing(@NotNull GatewayPingEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onResumed(@NotNull ResumedEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onReconnected(@NotNull ReconnectedEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onDisconnect(@NotNull DisconnectEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onShutdown(@NotNull ShutdownEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onStatusChange(@NotNull StatusChangeEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onException(@NotNull ExceptionEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onUserUpdateName(@NotNull UserUpdateNameEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onUserUpdateDiscriminator(@NotNull UserUpdateDiscriminatorEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onUserUpdateAvatar(@NotNull UserUpdateAvatarEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onUserUpdateOnlineStatus(@NotNull UserUpdateOnlineStatusEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onUserUpdateActivityOrder(@NotNull UserUpdateActivityOrderEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onUserUpdateFlags(@NotNull UserUpdateFlagsEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onUserTyping(@NotNull UserTypingEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onUserActivityStart(@NotNull UserActivityStartEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onUserActivityEnd(@NotNull UserActivityEndEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onSelfUpdateAvatar(@NotNull SelfUpdateAvatarEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onSelfUpdateMFA(@NotNull SelfUpdateMFAEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onSelfUpdateName(@NotNull SelfUpdateNameEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onSelfUpdateVerified(@NotNull SelfUpdateVerifiedEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildMessageUpdate(@NotNull GuildMessageUpdateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildMessageDelete(@NotNull GuildMessageDeleteEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildMessageEmbed(@NotNull GuildMessageEmbedEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildMessageReactionAdd(@NotNull GuildMessageReactionAddEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildMessageReactionRemove(@NotNull GuildMessageReactionRemoveEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildMessageReactionRemoveAll(@NotNull GuildMessageReactionRemoveAllEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildMessageReactionRemoveEmote(@NotNull GuildMessageReactionRemoveEmoteEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onPrivateMessageReceived(@NotNull PrivateMessageReceivedEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onPrivateMessageUpdate(@NotNull PrivateMessageUpdateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onPrivateMessageDelete(@NotNull PrivateMessageDeleteEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onPrivateMessageEmbed(@NotNull PrivateMessageEmbedEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onPrivateMessageReactionAdd(@NotNull PrivateMessageReactionAddEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onPrivateMessageReactionRemove(@NotNull PrivateMessageReactionRemoveEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onMessageUpdate(@NotNull MessageUpdateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onMessageDelete(@NotNull MessageDeleteEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onMessageBulkDelete(@NotNull MessageBulkDeleteEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onMessageEmbed(@NotNull MessageEmbedEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onMessageReactionRemove(@NotNull MessageReactionRemoveEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onMessageReactionRemoveAll(@NotNull MessageReactionRemoveAllEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onMessageReactionRemoveEmote(@NotNull MessageReactionRemoveEmoteEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onPermissionOverrideDelete(@NotNull PermissionOverrideDeleteEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onPermissionOverrideUpdate(@NotNull PermissionOverrideUpdateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onPermissionOverrideCreate(@NotNull PermissionOverrideCreateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onStoreChannelDelete(@NotNull StoreChannelDeleteEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onStoreChannelUpdateName(@NotNull StoreChannelUpdateNameEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onStoreChannelUpdatePosition(@NotNull StoreChannelUpdatePositionEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onStoreChannelCreate(@NotNull StoreChannelCreateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onTextChannelDelete(@NotNull TextChannelDeleteEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onTextChannelUpdateName(@NotNull TextChannelUpdateNameEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onTextChannelUpdateTopic(@NotNull TextChannelUpdateTopicEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onTextChannelUpdatePosition(@NotNull TextChannelUpdatePositionEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onTextChannelUpdateNSFW(@NotNull TextChannelUpdateNSFWEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onTextChannelUpdateParent(@NotNull TextChannelUpdateParentEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onTextChannelUpdateSlowmode(@NotNull TextChannelUpdateSlowmodeEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onTextChannelUpdateNews(@NotNull TextChannelUpdateNewsEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onTextChannelCreate(@NotNull TextChannelCreateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onVoiceChannelDelete(@NotNull VoiceChannelDeleteEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onVoiceChannelUpdateName(@NotNull VoiceChannelUpdateNameEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onVoiceChannelUpdatePosition(@NotNull VoiceChannelUpdatePositionEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onVoiceChannelUpdateUserLimit(@NotNull VoiceChannelUpdateUserLimitEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onVoiceChannelUpdateBitrate(@NotNull VoiceChannelUpdateBitrateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onVoiceChannelUpdateParent(@NotNull VoiceChannelUpdateParentEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onVoiceChannelCreate(@NotNull VoiceChannelCreateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onCategoryDelete(@NotNull CategoryDeleteEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onCategoryUpdateName(@NotNull CategoryUpdateNameEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onCategoryUpdatePosition(@NotNull CategoryUpdatePositionEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onCategoryCreate(@NotNull CategoryCreateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onPrivateChannelCreate(@NotNull PrivateChannelCreateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onPrivateChannelDelete(@NotNull PrivateChannelDeleteEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildLeave(@NotNull GuildLeaveEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildAvailable(@NotNull GuildAvailableEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUnavailable(@NotNull GuildUnavailableEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onUnavailableGuildJoined(@NotNull UnavailableGuildJoinedEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onUnavailableGuildLeave(@NotNull UnavailableGuildLeaveEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildBan(@NotNull GuildBanEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUnban(@NotNull GuildUnbanEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateAfkChannel(@NotNull GuildUpdateAfkChannelEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateSystemChannel(@NotNull GuildUpdateSystemChannelEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateAfkTimeout(@NotNull GuildUpdateAfkTimeoutEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateExplicitContentLevel(@NotNull GuildUpdateExplicitContentLevelEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateIcon(@NotNull GuildUpdateIconEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateMFALevel(@NotNull GuildUpdateMFALevelEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateName(@NotNull GuildUpdateNameEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateNotificationLevel(@NotNull GuildUpdateNotificationLevelEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateOwner(@NotNull GuildUpdateOwnerEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateRegion(@NotNull GuildUpdateRegionEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateSplash(@NotNull GuildUpdateSplashEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateVerificationLevel(@NotNull GuildUpdateVerificationLevelEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateLocale(@NotNull GuildUpdateLocaleEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateFeatures(@NotNull GuildUpdateFeaturesEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateVanityCode(@NotNull GuildUpdateVanityCodeEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateBanner(@NotNull GuildUpdateBannerEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateDescription(@NotNull GuildUpdateDescriptionEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateBoostTier(@NotNull GuildUpdateBoostTierEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateBoostCount(@NotNull GuildUpdateBoostCountEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateMaxMembers(@NotNull GuildUpdateMaxMembersEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildUpdateMaxPresences(@NotNull GuildUpdateMaxPresencesEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildInviteCreate(@NotNull GuildInviteCreateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildInviteDelete(@NotNull GuildInviteDeleteEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildMemberRoleAdd(@NotNull GuildMemberRoleAddEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildMemberRoleRemove(@NotNull GuildMemberRoleRemoveEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildMemberUpdate(@NotNull GuildMemberUpdateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildMemberUpdateNickname(@NotNull GuildMemberUpdateNicknameEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildMemberUpdateBoostTime(@NotNull GuildMemberUpdateBoostTimeEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildVoiceMove(@NotNull GuildVoiceMoveEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildVoiceLeave(@NotNull GuildVoiceLeaveEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildVoiceMute(@NotNull GuildVoiceMuteEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildVoiceDeafen(@NotNull GuildVoiceDeafenEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildVoiceGuildMute(@NotNull GuildVoiceGuildMuteEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildVoiceGuildDeafen(@NotNull GuildVoiceGuildDeafenEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildVoiceSelfMute(@NotNull GuildVoiceSelfMuteEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildVoiceSelfDeafen(@NotNull GuildVoiceSelfDeafenEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildVoiceSuppress(@NotNull GuildVoiceSuppressEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGuildVoiceStream(@NotNull GuildVoiceStreamEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onRoleCreate(@NotNull RoleCreateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onRoleDelete(@NotNull RoleDeleteEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onRoleUpdateColor(@NotNull RoleUpdateColorEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onRoleUpdateHoisted(@NotNull RoleUpdateHoistedEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onRoleUpdateMentionable(@NotNull RoleUpdateMentionableEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onRoleUpdateName(@NotNull RoleUpdateNameEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onRoleUpdatePermissions(@NotNull RoleUpdatePermissionsEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onRoleUpdatePosition(@NotNull RoleUpdatePositionEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onEmoteAdded(@NotNull EmoteAddedEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onEmoteRemoved(@NotNull EmoteRemovedEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onEmoteUpdateName(@NotNull EmoteUpdateNameEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onEmoteUpdateRoles(@NotNull EmoteUpdateRolesEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onHttpRequest(@NotNull HttpRequestEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericMessage(@NotNull GenericMessageEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericMessageReaction(@NotNull GenericMessageReactionEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericGuildMessage(@NotNull GenericGuildMessageEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericGuildMessageReaction(@NotNull GenericGuildMessageReactionEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericPrivateMessage(@NotNull GenericPrivateMessageEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericPrivateMessageReaction(@NotNull GenericPrivateMessageReactionEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericUser(@NotNull GenericUserEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericSelfUpdate(@NotNull GenericSelfUpdateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericStoreChannel(@NotNull GenericStoreChannelEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericStoreChannelUpdate(@NotNull GenericStoreChannelUpdateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericTextChannel(@NotNull GenericTextChannelEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericTextChannelUpdate(@NotNull GenericTextChannelUpdateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericVoiceChannel(@NotNull GenericVoiceChannelEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericVoiceChannelUpdate(@NotNull GenericVoiceChannelUpdateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericCategory(@NotNull GenericCategoryEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericCategoryUpdate(@NotNull GenericCategoryUpdateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericGuild(@NotNull GenericGuildEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericGuildUpdate(@NotNull GenericGuildUpdateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericGuildInvite(@NotNull GenericGuildInviteEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericGuildMember(@NotNull GenericGuildMemberEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericGuildMemberUpdate(@NotNull GenericGuildMemberUpdateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericGuildVoice(@NotNull GenericGuildVoiceEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericRole(@NotNull GenericRoleEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericRoleUpdate(@NotNull GenericRoleUpdateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericEmote(@NotNull GenericEmoteEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericEmoteUpdate(@NotNull GenericEmoteUpdateEvent event) {
        Helper.getEventManager().callEvent(event);
    }

    @Override
    public void onGenericPermissionOverride(@NotNull GenericPermissionOverrideEvent event) {
        Helper.getEventManager().callEvent(event);
    }
}