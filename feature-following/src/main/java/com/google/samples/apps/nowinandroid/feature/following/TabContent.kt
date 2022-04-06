/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.nowinandroid.feature.following

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.google.samples.apps.nowinandroid.core.model.data.FollowableAuthor
import com.google.samples.apps.nowinandroid.core.model.data.FollowableTopic

@Composable
fun TopicsTabContent(
    topics: List<FollowableTopic>,
    onTopicClick: (Int) -> Unit,
    onFollowButtonClick: (Int, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        topics.forEach { followableTopic ->
            item {
                FollowingItem(
                    name = followableTopic.topic.name,
                    following = followableTopic.isFollowed,
                    description = followableTopic.topic.shortDescription,
                    topicImageUrl = followableTopic.topic.imageUrl,
                    onClick = { onTopicClick(followableTopic.topic.id) },
                    onFollowButtonClick = { onFollowButtonClick(followableTopic.topic.id, it) }
                )
            }
        }
    }
}

@Composable
fun AuthorsTabContent(
    authors: List<FollowableAuthor>,
    onAuthorClick: () -> Unit,
    onFollowButtonClick: (Int, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        authors.forEach { followableTopic ->
            item {
                FollowingItem(
                    name = followableTopic.author.name,
                    following = followableTopic.isFollowed,
                    topicImageUrl = followableTopic.author.imageUrl,
                    onClick = onAuthorClick,
                    onFollowButtonClick = { onFollowButtonClick(followableTopic.author.id, it) },
                    iconModifier = Modifier.clip(CircleShape)
                )
            }
        }
    }
}
