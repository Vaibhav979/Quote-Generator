public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> find
    
}
