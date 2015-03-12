Scenario: Retrieve a post using postid, versionid

When I try to retrieve a post using postid=1, versionid=1
Then I get the post with postid=1, versionid=1

Scenario: Retrieve a post using postid, versionid

Given number of posts 10
When I try to retrieve a post using postid=10, versionid=1
Then I get the post with postid=10, versionid=1

Scenario: Retrieve a post using postid, versionid (not valid)

When I try to retrieve a post using postid=1, versionid=2
Then I get null

Scenario: Retrieve a post using postid, versionid (not valid)

When I try to retrieve a post using postid=10, versionid=1
Then I get null
