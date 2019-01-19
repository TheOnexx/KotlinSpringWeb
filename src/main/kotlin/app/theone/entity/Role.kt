package app.theone.entity

import javax.persistence.*

@Entity
@Table(name = "roles", schema = "public")
data class Role (
    @Id
    @Column(name = "role_id")
    var role: Long,

    @Column(name = "role_text")
    var roleText: String,

    @Column(name ="role_description")
    var roleDescription: String,

    @ManyToMany(mappedBy = "roles")
    var userId: MutableSet<User>?
)