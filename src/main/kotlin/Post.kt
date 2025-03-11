fun main() {

    var post = Post(comments = Comments("Commentariy"), likes = Likes(65))
    var post1 = post.copy()
    var wall = WallService
    wall.add(post)
    wall.add(post1)
    wall.update(Post(id = 1, comments = Comments("Commentation"), likes = Likes(79)))
    println(wall.array[0].toString())
    println(wall.array[1].toString())

}

class Comments(var commnts: String) {
    override fun toString(): String {
        return "$commnts"
    }
}

class Likes(var likes: Int) {
    override fun toString(): String {
        return "$likes"
    }
}

data class Post(
    var id: Int = 0,
    val ownerId: Int = 15,
    val fromId: Int = 45,
    val createdBy: String = "Инкогнито",
    val friendsOnly: Boolean = false,
    val text: String = "Нет текста",
    val comments: Comments = Comments("Нет коментариев"),
    val likes: Likes = Likes(0),
    val views: Int = 0,
    var origin: Post? = null
)

object WallService {
    var array = emptyArray<Post>()
    private var uniqueId = 1

    fun add(post: Post): Post {
        post.id = uniqueId++
        array += post
        return array.last()
    }

    fun update(posts: Post): Boolean {
        for ((index, post) in array.withIndex()) {
            if (post.id == posts.id) {
                array[index] = posts
                return true
            }
        }
        return false
    }

    fun clear(){
        array = emptyArray<Post>()
        uniqueId = 1
    }
}