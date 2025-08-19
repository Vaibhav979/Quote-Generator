public interface UserRepository extends JpaRepository<User, Long> {
    // This interface will automatically provide CRUD operations for User entities
    // No additional methods are needed unless you want to define custom queries
    
}
