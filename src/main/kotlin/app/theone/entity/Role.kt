package app.theone.entity

import javax.persistence.*

@Entity
@Table(name = "roles", schema = "public")
data class Role (
    @Column(name = "role_text")
    var roleText: String,

    @Column(name = "role_description")
    var roleDescription: String,

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    var userId: MutableSet<User>?
) {

    @Id
    @Column(name = "role_id")
    @GeneratedValue
    var role: Long? = null
}